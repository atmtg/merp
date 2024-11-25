package merp.model.primitives.weapon;

import merp.model.primitives.*;
import merp.model.primitives.table.AttackTables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponBuilderTest {

    @Test
    public void cannotBuildWeaponWithoutSettingAttackTable() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertNotNull(weapon);
    }

    @Test
    public void attackTableCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), null);
        });
    }

    @Test
    public void defaultWeaponHasNoPrimaryCriticalTable() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertEquals(CriticalHitTable.NONE, weapon.primaryCriticalTable());
    }

    @Test
    public void defaultWeaponHasNoSecondaryCriticalTable() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertEquals(CriticalHitTable.NONE, weapon.secondaryCriticalTable());
    }

    @Test
    public void canSetPrimaryCriticalTable() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withPrimaryCriticalHitTable(CriticalHitTable.GR).build();
        assertEquals(CriticalHitTable.GR, weapon.primaryCriticalTable());
    }

    @Test
    public void canSetSecondaryCriticalTable() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withSecondaryCriticalHitTable(CriticalHitTable.GR).build();
        assertEquals(CriticalHitTable.GR, weapon.secondaryCriticalTable());
    }

    @Test
    public void primaryCriticalTableCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withPrimaryCriticalHitTable(null);
        });
    }

    @Test
    public void secondaryCriticalTableCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withSecondaryCriticalHitTable(null);
        });
    }

    @Test
    public void canSetLimitForPrimaryCriticalHit() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withPrimaryCriticalHitLimit(CriticalHitSeverity.A).build();
        assertEquals(CriticalHitSeverity.A, weapon.primaryCriticalHitLimit());
    }

    @Test
    public void primaryCriticalHitLimitMustNotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withPrimaryCriticalHitLimit(null);
        });
    }

    @Test
    public void defaultWeaponHasNoPrimaryCriticalHitLimit() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertEquals(CriticalHitSeverity.NONE, weapon.primaryCriticalHitLimit());
    }

    @Test
    public void canSetLimitForSecondaryCriticalHit() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withSecondaryCriticalHitLimit(CriticalHitSeverity.A).build();
        assertEquals(CriticalHitSeverity.A, weapon.secondaryCriticalHitLimit());
    }

    @Test
    public void secondaryCriticalHitLimitMustNotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withSecondaryCriticalHitLimit(null);
        });
    }

    @Test
    public void defaultWeaponHasNoSecondaryCriticalHitLimit() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertEquals(CriticalHitSeverity.NONE, weapon.secondaryCriticalHitLimit());
    }

    @Test
    public void defaultWeaponHasNoGeneralModifier() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertEquals(1, weapon.applyModifiers(Roll.of(1), Armour.PLATE).value());
    }

    @Test
    public void canSetGeneralModifier() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withGeneralModifier(Modifier.of(10)).build();
        assertEquals(11, weapon.applyModifiers(Roll.of(1), Armour.PLATE).value());
    }

    @Test
    public void generalModifierCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withGeneralModifier(null);
        });
    }

    @Test
    public void defaultWeaponHasNoArmourModifier() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertEquals(1, weapon.applyModifiers(Roll.of(1), Armour.PLATE).value());
    }

    @Test
    public void canSetArmourModifier() {
        ArmourModifier armourModifier = ArmourModifier.of(Modifier.of(1), Modifier.of(2),
                Modifier.of(3), Modifier.of(4), Modifier.of(5));
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withArmourModifier(armourModifier).build();
        assertEquals(2, weapon.applyModifiers(Roll.of(1), Armour.PLATE).value());
    }

    @Test
    public void armourModifierCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withArmourModifier(null);
        });
    }

    @Test
    public void canSetFumbleRange() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withFumble(Range.of(1, 4)).build();
        assertTrue(weapon.isFumble(Roll.of(2)));
    }

    @Test
    public void fumbleRangeCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withFumble(null);
        });
    }

    @Test
    public void defaultWeaponHasNoFumbleRange() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertFalse(weapon.isFumble(Roll.of(1)));
    }

    @Test
    public void canSetBaseRange() {
        Weapon weapon = new WeaponBuilder()
                .withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING)
                .withBaseRange(BaseRange.of(10)).build();

        assertEquals(BaseRange.of(10), weapon.baseRange());
    }

    @Test
    public void defaultWeaponHasNoBaseRange() {
        Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build();
        assertEquals(BaseRange.of(0), weapon.baseRange());
    }

    @Test
    public void baseRangeCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).withBaseRange(null);
        });
    }

   @Test
   public void canSetNameOfWeapon() {
       Weapon weapon = new WeaponBuilder().withNameAndAttackTable(Name.of("The Name"), AttackTables.MISSILE).build();
       assertEquals("The Name", weapon.toString());
   }

    @Test
    public void nameCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new WeaponBuilder().withNameAndAttackTable(null, AttackTables.SLASHING);
        });
    }
}
