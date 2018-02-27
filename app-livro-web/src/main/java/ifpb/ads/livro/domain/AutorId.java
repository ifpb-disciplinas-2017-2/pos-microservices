package ifpb.ads.livro.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AutorId implements Serializable {

    private String value;

    public String getValue() {
        return value;
    }

    public void seValue(String value) {
        this.value = value;
    }

    public AutorId() {
        this.value = null;
    }

    public AutorId(String value) {
        this.value = value;
    }

    public static AutorId of(String autor) {
        return new AutorId(autor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AutorId) {
            AutorId other = (AutorId) obj;
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
        return String.format("Id do autor:%d", value);
    }

}
