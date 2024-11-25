package merp.model.primitives;

import java.io.Serializable;
import java.util.Objects;

public class Range implements Serializable {
    public static final Range NONE = new Range(0, 0);

    private int min;
    private int max;

    private Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Range of(int min, int max) {
        return new Range(min, max);
    }

    public int min() {
        return this.min;
    }

    public int max() {
        return this.max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return min == range.min && max == range.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
