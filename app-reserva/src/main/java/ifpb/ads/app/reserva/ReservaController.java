package ifpb.ads.app.reserva;

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

@Path("reserva")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class ReservaController {

    @Inject
    private ReservaRepository reservas;

//    public static final String REST_SERVICE_URI = "http://app-reserva:8080/reserva";
    @GET
    @Produc
    public Reserva todasReservas() {
        return reservas.;
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") long id) {
       Reserva reserva = reservas.findOne(id);

        if (reserva != null) {
            return Response.ok(reserva).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response add(@Context UriInfo info) {
        Reserva retorno = reservas.save(new Reserva());
        String id = String.valueOf(retorno.getId());
        URI uri = info.getAbsolutePathBuilder().path(id).build();
        return Response.created(uri)
                .entity(retorno)
                .build();
    }   
}