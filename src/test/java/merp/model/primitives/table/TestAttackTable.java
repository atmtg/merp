package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;
import merp.model.primitives.ModifiedRoll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAttackTable {
    @Test
    public void tryingToReadBeyondEndOfTableReturnsMaxResult() {
        assertEquals(AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.E),
                AttackTables.CONCUSSION.readResult(Armour.NONE, ModifiedRoll.of(200)));
    }

    @Test
    public void tryingToReadBeyondStartOfTableReturnsMinResult() {
        assertEquals(AttackTableEntry.of(HitPointsDamage.MISS),
                AttackTables.CONCUSSION.readResult(Armour.NONE, ModifiedRoll.of(-20)));
    }
}
