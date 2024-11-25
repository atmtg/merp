package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;

public class AttackTableNormalTeethAndClaws extends AttackTableSmallTeethAndClaws {

    private static final int MAX = 120;

    protected AttackTableNormalTeethAndClaws() {
        super();
        for (int i = 106; i <= 110; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.A));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.A));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(12), CriticalHitSeverity.B));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(15), CriticalHitSeverity.B));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(17), CriticalHitSeverity.C));
        }
        for (int i = 111; i <= 115; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(9), CriticalHitSeverity.A));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(11), CriticalHitSeverity.B));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.B));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(16), CriticalHitSeverity.C));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(19), CriticalHitSeverity.C));
        }
        for (int i = 116; i <= MAX; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.B));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(11), CriticalHitSeverity.B));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(14), CriticalHitSeverity.C));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(17), CriticalHitSeverity.C));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.D));
        }
    }

    @Override
    public int max() {
        return MAX;
    }

    public AttackTable setUp() {
        return new AttackTableNormalTeethAndClaws();
    }
}
