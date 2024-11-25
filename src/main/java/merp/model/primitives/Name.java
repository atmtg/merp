package merp.model.primitives;

import java.io.Serializable;
import java.util.Objects;

public class Name implements Serializable {
    private String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name of(String value) {
        assert value != null && value.length() > 0;

        return new Name(value);
    }

    @Override
    public String toString() {
        return value();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
