package ifpb.ads.app.autor;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 28/02/2018, 14:07:00
 */
@Named
@RequestScoped
public class ControladorDeAutor {

    private Autor autor = new Autor();

    @Inject
    private ConsumerAutor consumer;

    public List<Autor> autores() {
        return consumer.autores();
    }

    public String salvar() {
        consumer.salvar(autor);
        return null;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
