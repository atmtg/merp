package merp.model.primitives;

import java.io.Serializable;
import java.util.Objects;

public class DefensiveBonus implements Serializable {
    private int value;

    private DefensiveBonus(int value) {
        this.value = value;
    }

    public static DefensiveBonus of(int value) {
        return new DefensiveBonus(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefensiveBonus that = (DefensiveBonus) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
