package merp.model.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHitPointsDamage {

    @Test
    public void hitpointsCannotBeNegative() {
        Assertions.assertThrows(AssertionError.class, () -> {
            HitPointsDamage.of(-1);});
    }

}
