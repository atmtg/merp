package merp.model.primitives;

import org.junit.jupiter.api.Test;

public class TestDefensiveBonus {

    @Test
    public void defensiveBonusCanBeZero() {
        DefensiveBonus.of(0);
    }

}
