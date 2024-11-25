package merp.model.primitives.table;

import merp.model.primitives.CriticalHitSeverity;
import merp.model.primitives.HitPointsDamage;

import java.io.Serializable;
import java.util.Objects;

public class AttackTableEntry implements Serializable {
    public static final AttackTableEntry MISS = new AttackTableEntry(HitPointsDamage.MISS, CriticalHitSeverity.NONE);

    private HitPointsDamage hitPointsDamage;
    private CriticalHitSeverity criticalHitSeverity;

    private AttackTableEntry(HitPointsDamage hitPointsDamage, CriticalHitSeverity criticalHitSeverity) {
        this.hitPointsDamage = hitPointsDamage;
        this.criticalHitSeverity = criticalHitSeverity;
    }

    public static AttackTableEntry of(HitPointsDamage hitPointsDamage) {
        return of(hitPointsDamage, CriticalHitSeverity.NONE);
    }

    public static AttackTableEntry of(HitPointsDamage hitPointsDamage, CriticalHitSeverity criticalHitSeverity) {
        assert hitPointsDamage != null;
        assert criticalHitSeverity != null;

        return new AttackTableEntry(hitPointsDamage, criticalHitSeverity);
    }

    public HitPointsDamage hitPointsDamage() {
        return hitPointsDamage;
    }

    public CriticalHitSeverity criticalHit() {
        return criticalHitSeverity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttackTableEntry that = (AttackTableEntry) o;
        return Objects.equals(hitPointsDamage, that.hitPointsDamage) && criticalHitSeverity == that.criticalHitSeverity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitPointsDamage, criticalHitSeverity);
    }
}
