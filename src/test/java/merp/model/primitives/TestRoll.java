package merp.model.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRoll {

    @Test
    public void rollCannotBeZero() {
        Assertions.assertThrows(AssertionError.class, () -> {Roll.of(0);});
    }

    @Test
    public void rollCannotBeNegative() {
        Assertions.assertThrows(AssertionError.class, () -> {Roll.of(-1);});
    }

    @Test
    public void rollCanBe100() {
        Roll.of(100);
    }

    @Test
    public void rollCannotBeOverHundred() {
        Assertions.assertThrows(AssertionError.class, () -> {Roll.of(101);});
    }

    @Test
    public void secondRollCanBeAddedIfFirstIsAbove96() {
        Roll firstRoll = Roll.of(96);
        Roll result = firstRoll.add(Roll.of(54));
        assertEquals(96+54, result.value());
    }

    @Test
    public void rollCannotBeAddedIfFirstRollBelow96() {
        Roll firstRoll = Roll.of(95);
        Assertions.assertThrows(AssertionError.class, () -> {firstRoll.add(Roll.of(54));});
    }

    @Test
    public void canApplyModifier() {
        Roll roll = Roll.of(96);
        roll = roll.modifyWith(Modifier.of(2));
        assertEquals(96+2, roll.value());
    }

    @Test
    public void modifierCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {Roll.of(4).modifyWith(null);});
    }

    @Test
    public void rollCanBeWithinRange() {
        assertTrue(Roll.of(10).isWithin(Range.of(0, 100)));
    }

    @Test
    public void rollCanBeOutsideOfRangeBelow() {
        assertFalse(Roll.of(10).isWithin(Range.of(50, 100)));
    }

    @Test
    public void rollCanBeOutsifdeOfRangeAbove() {
        assertFalse(Roll.of(10).isWithin(Range.of(0, 1)));
    }

    @Test
    public void endpointsAreIncludedInRange() {
        assertTrue(Roll.of(10).isWithin(Range.of(10, 100)));
        assertTrue(Roll.of(10).isWithin(Range.of(0, 10)));
    }
}
