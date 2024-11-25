package merp.model.primitives;

import java.util.Objects;

public class Roll {

    private static final int MIN = 1;
    private static final int MAX = 100;

    private int value;

    protected Roll(int value) {
        this.value = value;
    }

    public static Roll of(int value) {
        assert value >= MIN && value <= MAX;

        return new Roll(value);
    }

    public Roll add(Roll secondRoll) {
        assert this.value() > 95;

        return new Roll(this.value() + secondRoll.value());
    }

    public ModifiedRoll modifyWith(Modifier modifier) {
        assert modifier != null;

        return ModifiedRoll.of(value + modifier.value());
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        return value == roll.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Boolean isWithin(Range range) {
        return this.value >= range.min() && this.value <= range.max();
    }
}
