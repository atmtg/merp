package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;

public class AttackTableHugeGrapplingAndUnbalancing extends AttackTableLargeGrapplingAndUnbalancing {

    private static final int MAX = 150;

    protected AttackTableHugeGrapplingAndUnbalancing() {
        super();
        for (int i = 136; i <= 140; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(14), CriticalHitSeverity.E));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(19), CriticalHitSeverity.D));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(22), CriticalHitSeverity.C));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(26), CriticalHitSeverity.D));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(28), CriticalHitSeverity.C));
        }
        for (int i = 141; i <= 145; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(16), CriticalHitSeverity.E));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(21), CriticalHitSeverity.E));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(25), CriticalHitSeverity.D));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(28), CriticalHitSeverity.D));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(30), CriticalHitSeverity.C));
        }
        for (int i = 146; i <= MAX; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(18), CriticalHitSeverity.E));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.E));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(27), CriticalHitSeverity.E));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(30), CriticalHitSeverity.E));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(33), CriticalHitSeverity.D));
        }
    }

    @Override
    public int max() {
        return MAX;
    }

    public AttackTable setUp() {
        return new AttackTableHugeGrapplingAndUnbalancing();
    }
}
