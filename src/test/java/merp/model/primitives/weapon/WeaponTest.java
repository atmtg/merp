package merp.model.primitives.weapon;

import merp.model.primitives.*;
import merp.model.primitives.table.AttackTable;
import merp.model.primitives.table.AttackTableEntry;
import merp.model.primitives.table.AttackTables;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {
    @Test
    public void wieldReadsResultFromAttackTable() {
        AttackTableEntry attackTableEntry = AttackTableEntry.of(HitPointsDamage.of(1000), CriticalHitSeverity.C);
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), new AttackTable() {
            @Override
            public AttackTableEntry readResult(Armour armour, Roll roll) {
                return attackTableEntry;
            }

            @Override
            public int max() {
                return 100;
            }
        }).build();
        AttackResult result = weapon.wieldAgainst(Roll.of(100), Armour.NONE);
        assertEquals(HitPointsDamage.of(1000), result.hitPointsDamage());
        assertEquals(CriticalHit.of(CriticalHitTable.NONE, CriticalHitSeverity.C), result.primaryCriticalHit());
    }

    @Test
    public void secondaryCriticalHitWhenSeverityCOrAbove() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"),AttackTables.TWOHAND)
                .withPrimaryCriticalHitTable(CriticalHitTable.SL)
                .withSecondaryCriticalHitTable(CriticalHitTable.PU).build();
        AttackResult result = weapon.wieldAgainst(ModifiedRoll.of(150), Armour.NONE);
        assertEquals("SL (E, +20)", result.primaryCriticalHit().toString());
        assertEquals("PU (C, ±0)", result.secondaryCriticalHit().toString());
    }

    @Test
    public void noSecondaryCriticalHitIfSecondaryCriticalHitTableNotSet() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"),AttackTables.TWOHAND)
                .withPrimaryCriticalHitTable(CriticalHitTable.SL).build();
        AttackResult result = weapon.wieldAgainst(ModifiedRoll.of(150), Armour.NONE);
        assertEquals("SL (E, +20)", result.primaryCriticalHit().toString());
        assertEquals("-", result.secondaryCriticalHit().toString());
    }

    @Test
    public void primaryCriticalHitCanBeLimited() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"),AttackTables.TWOHAND)
                .withPrimaryCriticalHitTable(CriticalHitTable.SL)
                .withPrimaryCriticalHitLimit(CriticalHitSeverity.A).build();
        AttackResult result = weapon.wieldAgainst(ModifiedRoll.of(150), Armour.NONE);
        assertEquals("SL (A, -20)", result.primaryCriticalHit().toString());
    }

    @Test
    public void noCriticalHitIsLimitedToNone() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"),AttackTables.TWOHAND)
                .withPrimaryCriticalHitTable(CriticalHitTable.SL)
                .withPrimaryCriticalHitLimit(CriticalHitSeverity.A).build();
        AttackResult result = weapon.wieldAgainst(ModifiedRoll.of(1), Armour.NONE);
        assertEquals("-", result.primaryCriticalHit().toString());
    }

    @Test
    public void secondaryCriticalHitCanBeLimited() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"),AttackTables.TWOHAND)
                .withPrimaryCriticalHitTable(CriticalHitTable.SL)
                .withSecondaryCriticalHitTable(CriticalHitTable.PU)
                .withSecondaryCriticalHitLimit(CriticalHitSeverity.A).build();
        AttackResult result = weapon.wieldAgainst(ModifiedRoll.of(150), Armour.NONE);
        assertEquals("SL (E, +20)", result.primaryCriticalHit().toString());
        assertEquals("PU (A, -20)", result.secondaryCriticalHit().toString());
    }
}
