package merp.model.primitives;

import java.io.Serializable;
import java.util.Objects;

public class HitPointsDamage implements Serializable {
    public static final HitPointsDamage MISS = new HitPointsDamage(-1);

    private static final int MIN = 0;

    private int value;

    private HitPointsDamage(int value) {
        this.value = value;
    }

    public static HitPointsDamage of(int value) {
        assert value >= MIN;

        return new HitPointsDamage(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitPointsDamage hitPointsDamage = (HitPointsDamage) o;
        return value == hitPointsDamage.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
