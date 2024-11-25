package merp.model.primitives;

import java.io.Serializable;
import java.util.Objects;

public class OffensiveBonus implements Serializable {
    private int value;

    private OffensiveBonus(int value) {
        this.value = value;
    }

    public static OffensiveBonus of(int value) {
        return new OffensiveBonus(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffensiveBonus that = (OffensiveBonus) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
