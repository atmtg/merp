package merp.model.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAttackResult {
    @Test
    public void damageCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            AttackResult.of(null);
        });
    }

    @Test
    public void primaryCritCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            AttackResult.of(HitPointsDamage.MISS, null);
        });
    }

    @Test
    public void secondaryCritCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            AttackResult.of(HitPointsDamage.MISS, CriticalHit.NONE, null);
        });
    }
}
