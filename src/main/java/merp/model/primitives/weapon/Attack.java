package merp.model.primitives.weapon;

import merp.model.primitives.Name;
import merp.model.primitives.OffensiveBonus;

import java.io.Serializable;
import java.util.Objects;

public class Attack implements Serializable {
    private Name name;
    private OffensiveBonus offensiveBonus;
    private Weapon weapon;
    private Boolean ranged;

    public Attack(Name nme, OffensiveBonus offensiveBonus, Weapon weapon, Boolean ranged) {
        this.name = nme;
        this.offensiveBonus = offensiveBonus;
        this.weapon = weapon;
        this.ranged = ranged;
    }

    public OffensiveBonus offensiveBonus() {
        return offensiveBonus;
    }

    public Weapon weapon() {
        return weapon;
    }

    public Boolean isRanged() {
        return ranged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attack attack = (Attack) o;
        return Objects.equals(offensiveBonus, attack.offensiveBonus) && Objects.equals(weapon, attack.weapon) && Objects.equals(ranged, attack.ranged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offensiveBonus, weapon, ranged);
    }

    public String toString() {
        return name.toString();
    }
}
