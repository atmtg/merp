package merp.model.primitives.character;

import merp.model.primitives.Armour;
import merp.model.primitives.DefensiveBonus;
import merp.model.primitives.Name;
import merp.model.primitives.weapon.Attack;

import java.util.ArrayList;
import java.util.Collection;

public class CharacterBuilder {

    private Name name;

    public CharacterBuilderWithName withName(Name name) {
        assert name != null;

        this.name = name;
        return new CharacterBuilderWithName();
    }

    public class CharacterBuilderWithName {
        private Armour armour;
        private DefensiveBonus defensiveBonus;
        private Collection<Attack> attacks;
        private Boolean hasShield;

        public CharacterBuilderWithName() {
            this.armour = Armour.NONE;
            this.defensiveBonus = DefensiveBonus.of(0);
            this.attacks = new ArrayList<>();
            this.hasShield = Boolean.FALSE;
        }

        public CharacterBuilderWithName withArmour(Armour armour) {
            assert armour != null;

            this.armour = armour;
            return this;
        }

        public CharacterBuilderWithName withDefensiveBonus(DefensiveBonus defensiveBonus) {
            assert defensiveBonus != null;

            this.defensiveBonus = defensiveBonus;
            return this;
        }

        public CharacterBuilderWithName withAttack(Attack attack) {
            assert attack != null;

            attacks.add(attack);
            return this;
        }

        public CharacterBuilderWithName withAttacks(Collection<Attack> attacks) {
            assert attacks != null;

            this.attacks.addAll(attacks);
            return this;
        }

        public CharacterBuilderWithName withShield(Boolean hasShield) {
            this.hasShield = hasShield;
            return this;
        }

        public Character build() {
            return new Character(name, armour, defensiveBonus, attacks, hasShield);
        }
    }
}
