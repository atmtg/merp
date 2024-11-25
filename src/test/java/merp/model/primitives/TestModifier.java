package merp.model.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModifier {

    @Test
    public void modifiedCanBeModified() {
        Modifier modified = Modifier.of(10).modifyWith(Modifier.of(20));
        assertEquals(Modifier.of(30), modified);
    }
}
