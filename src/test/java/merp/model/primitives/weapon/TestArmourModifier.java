package merp.model.primitives.weapon;

import merp.model.primitives.Modifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestArmourModifier {
    @Test
    public void plateArmourCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            ArmourModifier.of(null, Modifier.of(0), Modifier.of(0), Modifier.of(0), Modifier.of(0));});
    }

    @Test
    public void mailArmourCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            ArmourModifier.of(Modifier.of(0), null, Modifier.of(0), Modifier.of(0), Modifier.of(0));});
    }

    @Test
    public void sturdyLeatherArmourCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            ArmourModifier.of(Modifier.of(0), Modifier.of(0), null, Modifier.of(0), Modifier.of(0));});
    }

    @Test
    public void softLeatherArmourCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            ArmourModifier.of(Modifier.of(0), Modifier.of(0), Modifier.of(0), null, Modifier.of(0));});
    }

    @Test
    public void noArmourCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            ArmourModifier.of(Modifier.of(0), Modifier.of(0), Modifier.of(0), Modifier.of(0), null);});
    }
}
