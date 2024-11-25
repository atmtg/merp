package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;

public class AttackTableSmallTeethAndClaws extends AttackTable {

    private static final int MAX = 105;

    protected AttackTableSmallTeethAndClaws() {
        super();
        for (int i = 1; i <= 2; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.NONE).put(i, AttackTableEntry.MISS);;
        }
        for (int i = 3; i <= 45; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
        }
        for (int i = 46; i <= 50; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(1)));
        }
        for (int i = 51; i <= 55; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(2)));
        }
        for (int i = 56; i <= 60; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(1)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(1)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(4)));
        }
        for (int i = 61; i <= 65; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(1)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(1)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(1)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(2)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(5), CriticalHitSeverity.T));
        }
        for (int i = 66; i <= 70; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(2)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(2)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(2)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(4)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(6), CriticalHitSeverity.T));
        }
        for (int i = 71; i <= 75; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(3)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(3)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(3)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(5)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.T));
        }
        for (int i = 76; i <= 80; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(4)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(4)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(5)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(7), CriticalHitSeverity.T));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(9), CriticalHitSeverity.A));
        }
        for (int i = 81; i <= 85; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(5)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(5)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(7), CriticalHitSeverity.T));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(9), CriticalHitSeverity.T));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.A));
        }
        for (int i = 86; i <= 90; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(6)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(6), CriticalHitSeverity.T));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.T));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.A));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(12), CriticalHitSeverity.A));
        }
        for (int i = 91; i <= 95; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(6), CriticalHitSeverity.T));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(7), CriticalHitSeverity.T));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(9), CriticalHitSeverity.A));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(11), CriticalHitSeverity.A));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.B));
        }
        for (int i = 96; i <= 100; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(7), CriticalHitSeverity.T));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.A));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.A));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(12), CriticalHitSeverity.A));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(14), CriticalHitSeverity.B));
        }
        for (int i = 101; i <= MAX; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(7), CriticalHitSeverity.A));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(9), CriticalHitSeverity.A));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(11), CriticalHitSeverity.A));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.B));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(15), CriticalHitSeverity.B));
        }
    }

    @Override
    public int max() {
        return MAX;
    }

    public AttackTable setUp() {
        return new AttackTableSmallTeethAndClaws();
    }
}
