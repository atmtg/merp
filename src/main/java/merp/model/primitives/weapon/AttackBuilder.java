package merp.model.primitives.weapon;

import merp.model.primitives.Name;
import merp.model.primitives.OffensiveBonus;

public class AttackBuilder {

    private Name name;
    private OffensiveBonus offensiveBonus;
    private Weapon weapon;

    public AttackBuilderWithOBAndWeapon withNameOffensiveBonusAndWeapon(Name name, OffensiveBonus offensiveBonus, Weapon weapon) {
        assert name != null;
        assert offensiveBonus != null;
        assert weapon != null;

        this.name = name;
        this.offensiveBonus = offensiveBonus;
        this.weapon = weapon;
        return new AttackBuilderWithOBAndWeapon();}

    public class AttackBuilderWithOBAndWeapon extends AttackBuilder {

        private Boolean ranged;

        public AttackBuilderWithOBAndWeapon() {
            this.ranged = Boolean.FALSE;
        }

        public Attack build() {
            return new Attack(name, offensiveBonus, weapon, ranged);
        };

        public AttackBuilderWithOBAndWeapon withRanged(Boolean ranged) {
            this.ranged = ranged;
            return this;
        }
    }
}
