package merp.model.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestName {

    @Test
    public void nameCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            Name.of(null);});
    }

    @Test
    public void nameCannotBeEmpty() {
        Assertions.assertThrows(AssertionError.class, () -> {
            Name.of("");});
    }

    @Test
    public void nameCanBePrinted() {
        assertEquals("Kalle", Name.of("Kalle").toString());
    }
}
