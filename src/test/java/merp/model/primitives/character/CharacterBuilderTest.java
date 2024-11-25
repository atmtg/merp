package merp.model.primitives.character;

import merp.model.primitives.Armour;
import merp.model.primitives.DefensiveBonus;
import merp.model.primitives.Name;
import merp.model.primitives.OffensiveBonus;
import merp.model.primitives.weapon.Attack;
import merp.model.primitives.weapon.AttackBuilder;
import merp.model.primitives.weapon.Weapons;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterBuilderTest {
    @Test
    public void characterMustHaveName() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).build();
        assertEquals("Kalle", character.getName().toString());
    }

    @Test
    public void nameCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new CharacterBuilder().withName(null).build();});
    }

    @Test
    public void defaultCharacterHasNoArmour() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).build();
        assertEquals(Armour.NONE, character.armour());
    }

    @Test
    public void canSetCharacterArmour() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).withArmour(Armour.PLATE).build();
        assertEquals(Armour.PLATE, character.armour());
    }

    @Test
    public void armourCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new CharacterBuilder().withName(Name.of("Kalle")).withArmour(null).build();});
    }

    @Test
    public void defaultCharacterHasNoDefensiveBonus() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).build();
        assertEquals(DefensiveBonus.of(0), character.defensiveBonus());
    }

    @Test
    public void canSetDefensiveBonus() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).withDefensiveBonus(DefensiveBonus.of(10)).build();
        assertEquals(DefensiveBonus.of(10), character.defensiveBonus());
    }

    @Test
    public void defensiveBonusCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new CharacterBuilder().withName(Name.of("Kalle")).withDefensiveBonus(null).build();});
    }

    @Test
    public void defaultCharacterHasNoAttacks() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).build();
        assertEquals(0, character.attacks().size());
    }

    @Test
    public void canAddAttack() {
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), OffensiveBonus.of(54),
                Weapons.BATTLE_AXE.build()).build();
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).withAttack(attack).build();
        assertEquals(1, character.attacks().size());
    }

    @Test
    public void canAddSeveralAttacks() {
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of("Test"), OffensiveBonus.of(54),
                Weapons.BATTLE_AXE.build()).build();
        Collection<Attack> attacks = new ArrayList<>();
        attacks.add(attack);
        attacks.add(attack);

        Character character = new CharacterBuilder().withName(Name.of("Kalle")).withAttacks(attacks).build();
        assertEquals(2, character.attacks().size());
    }

    @Test
    public void attackCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new CharacterBuilder().withName(Name.of("Kalle")).withAttack(null).build();});
    }

    @Test
    public void attacksCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            new CharacterBuilder().withName(Name.of("Kalle")).withAttacks(null).build();});
    }

    @Test
    public void defaultCharacterHasNoShield() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).build();
        assertFalse(character.hasShield());
    }

    @Test
    public void canGiveCharacterShield() {
        Character character = new CharacterBuilder().withName(Name.of("Kalle")).withShield(true).build();
        assertTrue(character.hasShield());
    }
}
