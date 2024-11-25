package merp.model.primitives.weapon;

import merp.model.primitives.*;
import merp.model.primitives.table.AttackTable;

public class WeaponBuilder {
    public WeaponBuilderWithNameAndAttackTable withNameAndAttackTable(Name name, AttackTable attackTable) {
        assert attackTable != null;
        assert name != null;

        return new WeaponBuilderWithNameAndAttackTable(name, attackTable);
    }

    public WeaponBuilderWithNameAndAttackTable fromWeapon(Weapon weapon) {
        return new WeaponBuilderWithNameAndAttackTable(weapon);
    }

    public class WeaponBuilderWithNameAndAttackTable {

        private Name name;
        private AttackTable attackTable;
        private CriticalHitTable primaryCriticalHitTable;
        private CriticalHitSeverity primaryCriticalHitLimit;
        private CriticalHitTable secondaryCriticalHitTable;
        private CriticalHitSeverity secondaryCriticalHitLimit;
        private Modifier generalModifier;
        private ArmourModifier armourModifier;
        private Range fumbleRange;
        private BaseRange baseRange;

        public WeaponBuilderWithNameAndAttackTable(Weapon from) {
            this.name = from.name();
            this.attackTable = from.attackTable();
            this.primaryCriticalHitTable = from.primaryCriticalTable();
            this.primaryCriticalHitLimit = from.primaryCriticalHitLimit();
            this.secondaryCriticalHitTable = from.secondaryCriticalTable();
            this.secondaryCriticalHitLimit = from.secondaryCriticalHitLimit();
            this.generalModifier = Modifier.of(0);
            this.armourModifier = from.armourModifier();
            this.fumbleRange = from.fumbleRange();
            this.baseRange = from.baseRange();
        }

        public WeaponBuilderWithNameAndAttackTable(Name name, AttackTable attackTable) {
            this.name = name;
            this.attackTable = attackTable;
            this.primaryCriticalHitTable = CriticalHitTable.NONE;
            this.primaryCriticalHitLimit = CriticalHitSeverity.NONE;
            this.secondaryCriticalHitTable = CriticalHitTable.NONE;
            this.secondaryCriticalHitLimit = CriticalHitSeverity.NONE;
            this.generalModifier = Modifier.of(0);
            this.armourModifier = ArmourModifier.NONE;
            this.fumbleRange = Range.NONE;
            this.baseRange = BaseRange.of(0);
        }

        public Weapon build() {
            return new Weapon(name, attackTable,
                    primaryCriticalHitTable,
                    primaryCriticalHitLimit,
                    secondaryCriticalHitTable,
                    secondaryCriticalHitLimit,
                    generalModifier,
                    armourModifier,
                    fumbleRange, baseRange);
        }

        public WeaponBuilderWithNameAndAttackTable withPrimaryCriticalHitTable(CriticalHitTable criticalHitTable) {
            assert criticalHitTable != null;

            this.primaryCriticalHitTable = criticalHitTable;
            return this;
        }

        public WeaponBuilderWithNameAndAttackTable withPrimaryCriticalHitLimit(CriticalHitSeverity criticalHitLimit) {
            assert criticalHitLimit != null;

            this.primaryCriticalHitLimit = criticalHitLimit;
            return this;
        }

        public WeaponBuilderWithNameAndAttackTable withSecondaryCriticalHitTable(CriticalHitTable criticalHitTable) {
            assert criticalHitTable != null;

            secondaryCriticalHitTable = criticalHitTable;
            return this;
        }

        public WeaponBuilderWithNameAndAttackTable withSecondaryCriticalHitLimit(CriticalHitSeverity criticalHitLimit) {
            assert criticalHitLimit != null;

            this.secondaryCriticalHitLimit = criticalHitLimit;
            return this;
        }

        public WeaponBuilderWithNameAndAttackTable withGeneralModifier(Modifier generalModifier) {
            assert generalModifier != null;

            this.generalModifier = generalModifier;
            return this;
        }

        public WeaponBuilderWithNameAndAttackTable withArmourModifier(ArmourModifier armourModifier) {
            assert armourModifier != null;

            this.armourModifier = armourModifier;
            return this;
        }

        public WeaponBuilderWithNameAndAttackTable withFumble(Range fumbleRange) {
            assert fumbleRange != null;

            this.fumbleRange = fumbleRange;
            return this;
        }

        public WeaponBuilderWithNameAndAttackTable withBaseRange(BaseRange baseRange) {
            assert baseRange != null;

            this.baseRange = baseRange;
            return this;
        }

        @Override
        public String toString() {
            return name.toString();
        }
    }
}
