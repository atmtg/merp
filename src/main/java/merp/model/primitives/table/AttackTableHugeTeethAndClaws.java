package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;

public class AttackTableHugeTeethAndClaws extends AttackTableLargeTeethAndClaws {

    private static final int MAX = 150;

    protected AttackTableHugeTeethAndClaws() {
        super();
        for (int i = 136; i <= 140; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.C));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.D));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(26), CriticalHitSeverity.D));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(30), CriticalHitSeverity.E));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(36), CriticalHitSeverity.E));
        }
        for (int i = 141; i <= 145; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(22), CriticalHitSeverity.D));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(25), CriticalHitSeverity.D));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(29), CriticalHitSeverity.E));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(33), CriticalHitSeverity.E));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(38), CriticalHitSeverity.E));
        }
        for (int i = 146; i <= MAX; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(24), CriticalHitSeverity.E));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(27), CriticalHitSeverity.E));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(32), CriticalHitSeverity.E));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(36), CriticalHitSeverity.E));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(40), CriticalHitSeverity.E));
        }
    }

    @Override
    public int max() {
        return MAX;
    }

    public AttackTable setUp() {
        return new AttackTableHugeTeethAndClaws();
    }
}
