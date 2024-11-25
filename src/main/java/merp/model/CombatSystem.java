package merp.model;

import merp.model.primitives.DefensiveBonus;
import merp.model.primitives.ModifiedRoll;
import merp.model.primitives.OffensiveBonus;
import merp.model.primitives.Roll;

public class CombatSystem {
    public static ModifiedRoll attackRoll(Roll roll, OffensiveBonus ob, DefensiveBonus db) {
        assert roll != null;
        assert ob != null;
        assert db != null;

        return ModifiedRoll.of(roll.value() + ob.value() - db.value());
    }
}
