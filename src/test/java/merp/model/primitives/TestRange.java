package merp.model.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRange {

    @Test
    public void rangeHasMinAndMax() {
        Range range = Range.of(0, 15);

        assertEquals(0, range.min());
        assertEquals(15, range.max());
    }
}
