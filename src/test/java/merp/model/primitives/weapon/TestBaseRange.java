package merp.model.primitives.weapon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBaseRange {

    @Test
    public void baseRangeCannotBeNegative() {
        Assertions.assertThrows(AssertionError.class, () -> {
            BaseRange.of(-1);});
    }
}
