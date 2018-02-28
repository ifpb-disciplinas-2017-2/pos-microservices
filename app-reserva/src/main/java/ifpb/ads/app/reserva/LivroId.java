package ifpb.ads.app.reserva;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;


@Embeddable
public class LivroId implements Serializable {

     private String value;

    public String getValue() {
        return value;
    }

    public void seValue(String value) {
        this.value = value;
    }

    public LivroId() {
        this.value = null;
    }

    public LivroId(String value) {
        this.value = value;
    }

    public static LivroId of(String livro) {
        return new LivroId(livro);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LivroId) {
            LivroId other = (LivroId) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return String.format("Id do livro:%d", value);
    }

}