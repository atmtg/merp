package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;

public class AttackTableLargeTeethAndClaws extends AttackTableNormalTeethAndClaws {

    private static final int MAX = 135;

    protected AttackTableLargeTeethAndClaws() {
        super();
        for (int i = 121; i <= 125; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(14), CriticalHitSeverity.B));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(15), CriticalHitSeverity.B));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(18), CriticalHitSeverity.C));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.C));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(26), CriticalHitSeverity.D));
        }
        for (int i = 126; i <= 130; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(16), CriticalHitSeverity.B));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(18), CriticalHitSeverity.C));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.C));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.D));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(28), CriticalHitSeverity.E));
        }
        for (int i = 131; i <= MAX; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(18), CriticalHitSeverity.C));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.C));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(22), CriticalHitSeverity.D));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(25), CriticalHitSeverity.D));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(30), CriticalHitSeverity.E));
        }
    }

    @Override
    public int max() {
        return MAX;
    }

    public AttackTable setUp() {
        return new AttackTableLargeTeethAndClaws();
    }
}
