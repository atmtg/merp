package merp.model.primitives.weapon;

import merp.model.primitives.Name;
import merp.model.primitives.OffensiveBonus;
import merp.model.primitives.table.AttackTables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttackBuilderTest {

    @Test
    public void attackHasName() {
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("The Name"), OffensiveBonus.of(10),
                Weapons.BATTLE_AXE.build()).build();

        assertEquals("The Name", attack.toString());
    }

    @Test
    public void attackHasOffensiveBonus() {
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), OffensiveBonus.of(10),
                new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build()).build();

        assertEquals(OffensiveBonus.of(10), attack.offensiveBonus());
    }

    @Test
    public void attackHasWeapon() {
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), OffensiveBonus.of(10),
                new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build()).build();

        assertEquals(new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build(), attack.weapon());
    }

    @Test
    public void nameCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new AttackBuilder().withNameOffensiveBonusAndWeapon(null, OffensiveBonus.of(10),
                    new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build());
        });
    }

    @Test
    public void offensiveBonusCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), null,
                    new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build());
        });
    }

    @Test
    public void weaponCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), OffensiveBonus.of(10), null);
        });
    }

    @Test
    public void attackCanBeRanged() {
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), OffensiveBonus.of(10),
                new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build()).withRanged(Boolean.TRUE).build();

        assertTrue(attack.isRanged());
    }

    @Test
    public void defaultAttackIsNotRanged() {
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), OffensiveBonus.of(10),
                new WeaponBuilder().withNameAndAttackTable(Name.of("Test"), AttackTables.SLASHING).build()).build();

        assertFalse(attack.isRanged());
    }
}
