package merp.model.primitives.table;

import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestAttackTableEntry {

    @Test
    public void attackResultContainsHitPointsDamageAndCriticalHit() {
        AttackTableEntry result = AttackTableEntry.of(HitPointsDamage.of(0), CriticalHitSeverity.NONE);
        assertNotNull(result);
        assertEquals(0, result.hitPointsDamage().value());
        assertEquals(CriticalHitSeverity.NONE, result.criticalHit());
    }

    @Test
    public void hitPointsDamageCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            AttackTableEntry.of(null, CriticalHitSeverity.NONE);});
    }

    @Test
    public void criticalHitCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            AttackTableEntry.of(HitPointsDamage.of(0), null);});
    }
}
