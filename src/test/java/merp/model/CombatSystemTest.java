package merp.model;

import merp.model.primitives.DefensiveBonus;
import merp.model.primitives.ModifiedRoll;
import merp.model.primitives.OffensiveBonus;
import merp.model.primitives.Roll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombatSystemTest {

    @Test
    public void attackRollAcceptsRollAndGeneratesModifiedRoll() {
        ModifiedRoll modifiedRoll = CombatSystem.attackRoll(Roll.of(45), OffensiveBonus.of(0), DefensiveBonus.of(0));
        assertEquals(45, modifiedRoll.value());
    }

    @Test
    public void attackRollDoesNotAcceptNullRoll() {
        Assertions.assertThrows(AssertionError.class, () -> {CombatSystem.attackRoll(null, OffensiveBonus.of(0), DefensiveBonus.of(0));});
    }

    @Test
    public void attackRollDoesNotAcceptNullOffensiveBonus() {
        Assertions.assertThrows(AssertionError.class, () -> {CombatSystem.attackRoll(Roll.of(34), null, DefensiveBonus.of(0));});
    }

    @Test
    public void attackRollDoesNotAcceptNullDefensiveBonus() {
        Assertions.assertThrows(AssertionError.class, () -> {CombatSystem.attackRoll(Roll.of(34), OffensiveBonus.of(0), null);});
    }

    @Test
    public void attackRollAddsOffensiveBonus() {
        ModifiedRoll modifiedRoll = CombatSystem.attackRoll(Roll.of(45), OffensiveBonus.of(25), DefensiveBonus.of(0));
        assertEquals(45 + 25, modifiedRoll.value());
    }

    @Test
    public void attackRollSubtractsNegativeOffensiveBonus() {
        ModifiedRoll modifiedRoll = CombatSystem.attackRoll(Roll.of(45), OffensiveBonus.of(-25), DefensiveBonus.of(0));
        assertEquals(45 - 25, modifiedRoll.value());
    }

    @Test
    public void attackRollSubtractsDefensiveBonus() {
        ModifiedRoll modifiedRoll = CombatSystem.attackRoll(Roll.of(45), OffensiveBonus.of(0), DefensiveBonus.of(25));
        assertEquals(45 - 25, modifiedRoll.value());
    }

    @Test
    public void attackRollAddsNegativeDefensiveBonus() {
        ModifiedRoll modifiedRoll = CombatSystem.attackRoll(Roll.of(45), OffensiveBonus.of(0), DefensiveBonus.of(-25));
        assertEquals(45 + 25, modifiedRoll.value());
    }
}
