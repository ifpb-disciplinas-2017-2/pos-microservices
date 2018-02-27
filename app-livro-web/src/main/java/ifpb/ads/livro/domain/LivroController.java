package ifpb.ads.livro.domain;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("livro")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class LivroController {

    @Inject
    private LivroRepository livros;

//    public static final String REST_SERVICE_URI = "http://app-autor:8080/autor";
    @GET
    public Livro[] todosOsLivros() {
        return livros.findAll().toArray(new Livro[0]);
    }

//    @GET
//    @Path("autores")
//    public Response getAutores() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        String autor = restTemplate.getForObject(REST_SERVICE_URI, String.class);
//        System.out.println(autor);
//        if (autor != null) {
//            return new Response<>(autor, HttpStatus.OK);
//        } else {
//            return new Response<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
    @GET
    @Path("{id}")
    public Response get(@PathParam("id") long id) {
        Livro livro = livros.findOne(id);

        if (livro != null) {
            return Response.ok(livro).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response add(Livro livro, @Context UriInfo info) {
        Livro retorno = livros.save(livro);
        String id = String.valueOf(retorno.getId());
        URI path = info.getAbsolutePathBuilder().path(LivroController.class)
                .path(id)
                .build();
        if (retorno != null) {
            return Response.created(path)
                    .entity(retorno)
                    .build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("{id}/autores")
    public AutorId[] getByLastName(@PathParam("id") long id) {
        return livros.getAutoresDoLivro(id).toArray(new AutorId[0]);
    }

    @PUT
    @Path("{id}/autores")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAutores(@PathParam("id") long id, String autor) {
        Livro livro = livros.findOne(id);
        if (livro != null) {
            livro.adicionarAutor(AutorId.of(autor));
            Livro retorno = livros.merge(livro);
            return Response.ok(retorno).build();
        }
        return Response.status(Status.NOT_FOUND).build();

    }
}
