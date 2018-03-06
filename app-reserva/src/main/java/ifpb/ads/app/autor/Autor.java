package ifpb.ads.app.autor;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 28/02/2018, 14:00:54
 */
@XmlRootElement
public class Autor implements Serializable {

    private String nome;
    private String email;
    private String abreviacao;
    private String _id;
    
    public Autor() {
    }

    public Autor(String nome, String email, String abreviacao, String _id) {
        this.nome = nome;
        this.email = email;
        this.abreviacao = abreviacao;
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    
}
