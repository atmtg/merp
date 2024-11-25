package merp.model.primitives.weapon;

import java.io.Serializable;
import java.util.Objects;

public class BaseRange implements Serializable {
    private int value;

    private BaseRange(int value) {
        this.value = value;
    }

    public static BaseRange of(int value) {
        assert value >= 0;

        return new BaseRange(value);
    }

    public int range() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseRange baseRange = (BaseRange) o;
        return value == baseRange.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
