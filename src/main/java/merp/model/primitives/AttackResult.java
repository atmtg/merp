package merp.model.primitives;

import java.util.Objects;

public class AttackResult {
    private HitPointsDamage damage;
    private CriticalHit primaryCriticalHit;
    private CriticalHit secondaryCriticalHit;

    private AttackResult(HitPointsDamage damage, CriticalHit primaryCriticalHit, CriticalHit secondaryCriticalHit) {
        this.damage = damage;
        this.primaryCriticalHit = primaryCriticalHit;
        this.secondaryCriticalHit = secondaryCriticalHit;
    }

    public static AttackResult of(HitPointsDamage damage) {
        return of(damage, CriticalHit.NONE);
    }

    public static AttackResult of(HitPointsDamage damage, CriticalHit primaryCriticalHit) {
        return of(damage, primaryCriticalHit, CriticalHit.NONE);
    }

    public static AttackResult of(HitPointsDamage damage, CriticalHit primaryCriticalHit, CriticalHit secondaryCriticalHit) {
        assert damage != null;
        assert primaryCriticalHit != null;
        assert secondaryCriticalHit != null;

        return new AttackResult(damage, primaryCriticalHit, secondaryCriticalHit);
    }

    public HitPointsDamage hitPointsDamage() {
        return damage;
    }

    public CriticalHit primaryCriticalHit() {
        return primaryCriticalHit;
    }

    public CriticalHit secondaryCriticalHit() {
        return secondaryCriticalHit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttackResult that = (AttackResult) o;
        return Objects.equals(damage, that.damage) && Objects.equals(primaryCriticalHit, that.primaryCriticalHit) && Objects.equals(secondaryCriticalHit, that.secondaryCriticalHit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(damage, primaryCriticalHit, secondaryCriticalHit);
    }
}
