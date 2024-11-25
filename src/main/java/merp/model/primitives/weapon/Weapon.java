package merp.model.primitives.weapon;

import merp.model.primitives.*;
import merp.model.primitives.table.AttackTable;
import merp.model.primitives.table.AttackTableEntry;

import java.io.Serializable;
import java.util.Objects;

public class Weapon implements Serializable {
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

    protected Weapon(Name name, AttackTable attackTable, CriticalHitTable primaryCriticalHitTable,
                     CriticalHitSeverity primaryCriticalHitLimit, CriticalHitTable secondaryCriticalHitTable,
                     CriticalHitSeverity secondaryCriticalHitLimit, Modifier generalModifier,
                     ArmourModifier armourModifier, Range fumbleRange, BaseRange baseRange) {
        this.name = name;
        this.attackTable = attackTable;
        this.primaryCriticalHitTable = primaryCriticalHitTable;
        this.primaryCriticalHitLimit = primaryCriticalHitLimit;
        this.secondaryCriticalHitTable = secondaryCriticalHitTable;
        this.secondaryCriticalHitLimit = secondaryCriticalHitLimit;
        this.generalModifier = generalModifier;
        this.armourModifier = armourModifier;
        this.fumbleRange = fumbleRange;
        this.baseRange = baseRange;
    }

    public AttackResult wieldAgainst(Roll roll, Armour armour) {
        AttackTableEntry tableEntry = attackTable.readResult(armour, roll);
        return AttackResult.of(tableEntry.hitPointsDamage(),
                limitedCriticalHit(primaryCriticalHitTable, tableEntry.criticalHit(), primaryCriticalHitLimit),
                secondaryCriticalHitOrNone(tableEntry));
    }

    private CriticalHit secondaryCriticalHitOrNone(AttackTableEntry tableEntry) {
        return isCSeverityOrAbove(tableEntry) && weaponHasSecondaryCriticalHitTable() ?
                limitedCriticalHit(secondaryCriticalHitTable, severityLoweredTwoSteps(tableEntry), secondaryCriticalHitLimit) :
                CriticalHit.NONE;
    }

    private CriticalHitSeverity severityLoweredTwoSteps(AttackTableEntry tableEntry) {
        return CriticalHitSeverity.values()[tableEntry.criticalHit().ordinal() - 2];
    }

    private boolean weaponHasSecondaryCriticalHitTable() {
        return this.secondaryCriticalHitTable != CriticalHitTable.NONE;
    }

    private boolean isCSeverityOrAbove(AttackTableEntry tableEntry) {
        return tableEntry.criticalHit().compareTo(CriticalHitSeverity.C) >= 0 &&
                tableEntry.criticalHit() != CriticalHitSeverity.NONE;
    }

    private CriticalHit limitedCriticalHit(CriticalHitTable criticalHitTable, CriticalHitSeverity criticalHitSeverity,
                                           CriticalHitSeverity criticalHitLimit) {
        return criticalHitSeverity.equals(CriticalHitSeverity.NONE) ? CriticalHit.NONE :
                CriticalHit.of(criticalHitTable, criticalHitSeverity).limitBy(criticalHitLimit);
    }

    protected CriticalHitTable primaryCriticalTable() {
        return primaryCriticalHitTable;
    }

    public CriticalHitSeverity primaryCriticalHitLimit() {
        return primaryCriticalHitLimit;
    }

    protected CriticalHitTable secondaryCriticalTable() {
        return secondaryCriticalHitTable;
    }

    public CriticalHitSeverity secondaryCriticalHitLimit() {
        return secondaryCriticalHitLimit;
    }

    public ModifiedRoll applyModifiers(Roll roll, Armour armour) {
        return roll.modifyWith(generalModifier).modifyWith(armourModifier.forArmour(armour));
    }

    public boolean isFumble(Roll roll) {
        return roll.isWithin(fumbleRange);
    }

    public BaseRange baseRange() {
        return baseRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(attackTable, weapon.attackTable) && primaryCriticalHitTable == weapon.primaryCriticalHitTable && primaryCriticalHitLimit == weapon.primaryCriticalHitLimit && secondaryCriticalHitTable == weapon.secondaryCriticalHitTable && secondaryCriticalHitLimit == weapon.secondaryCriticalHitLimit && Objects.equals(generalModifier, weapon.generalModifier) && Objects.equals(armourModifier, weapon.armourModifier) && Objects.equals(fumbleRange, weapon.fumbleRange) && Objects.equals(baseRange, weapon.baseRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attackTable, primaryCriticalHitTable, primaryCriticalHitLimit, secondaryCriticalHitTable, secondaryCriticalHitLimit, generalModifier, armourModifier, fumbleRange, baseRange);
    }

    @Override
    public String toString() {
        return name.toString() + (this.generalModifier.value() != 0 ? "(+" + generalModifier.value() + ")" : "");
    }

    public ArmourModifier armourModifier() {
        return this.armourModifier;
    }

    public Range fumbleRange() {
        return this.fumbleRange;
    }

    public AttackTable attackTable() {
        return this.attackTable;
    }

    public Modifier generalModifier() {
        return this.generalModifier;
    }

    public Name name() {
        return this.name;
    }
}
