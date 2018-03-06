package ifpb.ads.app.autor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 28/02/2018, 14:01:50
 */
@Named
@RequestScoped
public class ConsumerAutor {

    private final String uri = "http://app-autor:8080/autor";
    private Client client = ClientBuilder.newClient();
    private WebTarget target = client.target(uri);

    public List<Autor> autores() {

        Response get = target.request(MediaType.APPLICATION_JSON)
                .get();

        JsonArray readEntity = get.readEntity(JsonArray.class);
        return readEntity.getValuesAs(JsonObject.class)
                .stream()
                .map((JsonObject t)
                        -> new Autor(t.getString("nome"),
                        t.getString("email"),
                        t.getString("abreviacao"),
                        t.getString("_id")))
                .collect(Collectors.toList());
    }

    public void salvar(Autor autor) {

        Form form = new Form("nome", autor.getNome())
                .param("email", autor.getEmail())
                .param("abreviacao", autor.getAbreviacao());

        Response post = target.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(Entity.form(form));

        System.out.println(post.readEntity(String.class));
        System.out.println(post.getHeaderString("location"));

    }

    public void excluir(Autor autor) {
        WebTarget delete = target.path("{id}").resolveTemplate("id", autor.getId());
        Response response = delete.request(MediaType.APPLICATION_JSON).delete();
        System.out.println(response.readEntity(String.class));
    }
}
