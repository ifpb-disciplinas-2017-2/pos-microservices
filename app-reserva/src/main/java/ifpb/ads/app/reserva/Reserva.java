package ifpb.ads.app.reserva;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wellington
 */
@Entity
@XmlRootElement
public class Reserva implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date data;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @Basic(fetch = FetchType.EAGER)
//    private List<LivroId> livros = new ArrayList();

    public Reserva() {
      
    }

    public Reserva(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public List<LivroId> getLivros() {
//        return livros;
//    }
//
//    public void setLivros(List<LivroId> livros) {
//        this.livros = livros;
//    }
//    
//       public void adicionarLivro(LivroId livro) {
//        this.livros.add(livro);
//    }
//
//    public void removerL4ivro(LivroId livro) {
//        this.livros.remove(livro);
//    }

}
