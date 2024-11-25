package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;

public class AttackTableMissile extends AttackTable {

    private static final int MAX = 150;

    protected AttackTableMissile() {
        super();
        for (int i = 1; i <= 8; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.MISS);
            theTable.get(Armour.NONE).put(i, AttackTableEntry.MISS);;
        }
        for (int i = 9; i <= 70; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
        }
        for (int i = 71; i <= 75; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(1)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
        }
        for (int i = 76; i <= 80; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(2)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(2)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(4)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
        }
        for (int i = 81; i <= 85; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(3)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(4)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(3)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(6)));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
        }
        for (int i = 86; i <= 90; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(4)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(6)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(5)));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.A));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(0)));
        }
        for (int i = 91; i <= 95; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(5)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(7)));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(7), CriticalHitSeverity.A));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.A));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.A));
        }
        for (int i = 96; i <= 100; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(6)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.A));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(9), CriticalHitSeverity.A));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(12), CriticalHitSeverity.B));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.B));
        }
        for (int i = 101; i <= 105; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(7)));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.A));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.B));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.B));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(11), CriticalHitSeverity.C));
        }
        for (int i = 106; i <= 110; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(8), CriticalHitSeverity.A));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.B));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(12), CriticalHitSeverity.B));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(14), CriticalHitSeverity.B));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.C));
        }
        for (int i = 111; i <= 115; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(9), CriticalHitSeverity.A));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(14), CriticalHitSeverity.B));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.B));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(16), CriticalHitSeverity.C));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(15), CriticalHitSeverity.C));
        }
        for (int i = 116; i <= 120; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(10), CriticalHitSeverity.A));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(16), CriticalHitSeverity.B));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(15), CriticalHitSeverity.C));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(17), CriticalHitSeverity.C));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(16), CriticalHitSeverity.D));
        }
        for (int i = 121; i <= 125; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(11), CriticalHitSeverity.B));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(17), CriticalHitSeverity.C));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(17), CriticalHitSeverity.C));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(19), CriticalHitSeverity.D));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(18), CriticalHitSeverity.D));
        }
        for (int i = 126; i <= 130; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(11), CriticalHitSeverity.B));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(19), CriticalHitSeverity.C));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(19), CriticalHitSeverity.D));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.D));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.D));
        }
        for (int i = 131; i <= 135; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(12), CriticalHitSeverity.C));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(20), CriticalHitSeverity.D));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(21), CriticalHitSeverity.D));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(22), CriticalHitSeverity.D));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(22), CriticalHitSeverity.E));
        }
        for (int i = 136; i <= 140; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(13), CriticalHitSeverity.C));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(22), CriticalHitSeverity.D));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.D));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.E));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.E));
        }
        for (int i = 141; i <= 145; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(14), CriticalHitSeverity.D));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(23), CriticalHitSeverity.E));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(25), CriticalHitSeverity.E));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(25), CriticalHitSeverity.E));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(25), CriticalHitSeverity.E));
        }
        for (int i = 146; i <= MAX; i++) {
            int finalI = i;
            theTable.get(Armour.PLATE).put(i, AttackTableEntry.of(HitPointsDamage.of(15), CriticalHitSeverity.E));
            theTable.get(Armour.CHAIN).put(i, AttackTableEntry.of(HitPointsDamage.of(25), CriticalHitSeverity.E));
            theTable.get(Armour.RIGID_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(26), CriticalHitSeverity.E));
            theTable.get(Armour.SOFT_LEATHER).put(i, AttackTableEntry.of(HitPointsDamage.of(26), CriticalHitSeverity.E));
            theTable.get(Armour.NONE).put(i, AttackTableEntry.of(HitPointsDamage.of(27), CriticalHitSeverity.E));
        }
    }

    @Override
    public int max() {
        return MAX;
    }

    public AttackTable setUp() {
        return new AttackTableMissile();
    }
}
