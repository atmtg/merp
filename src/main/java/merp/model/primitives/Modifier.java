package merp.model.primitives;

import java.io.Serializable;
import java.util.Objects;

public class Modifier implements Serializable {

    private int value;

    private Modifier(int value) {
        this.value = value;
    }

    public static Modifier of(int value) {
        return new Modifier(value);
    }

    public int value() {
        return value;
    }

    public Modifier modifyWith(Modifier other) {
        return Modifier.of(value + other.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modifier modifier = (Modifier) o;
        return value == modifier.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
