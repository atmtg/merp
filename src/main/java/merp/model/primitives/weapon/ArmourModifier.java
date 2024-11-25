package merp.model.primitives.weapon;

import merp.model.primitives.Armour;
import merp.model.primitives.Modifier;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArmourModifier implements Serializable {

    public static final ArmourModifier NONE = ArmourModifier.of(Modifier.of(0),
            Modifier.of(0), Modifier.of(0), Modifier.of(0), Modifier.of(0));

    Map<Armour, Modifier> modifiers;

    public ArmourModifier(Modifier me, Modifier ri, Modifier hä, Modifier mj, Modifier in) {
        modifiers = new HashMap<>();
        modifiers.put(Armour.PLATE, me);
        modifiers.put(Armour.CHAIN, ri);
        modifiers.put(Armour.RIGID_LEATHER, hä);
        modifiers.put(Armour.SOFT_LEATHER, mj);
        modifiers.put(Armour.NONE, in);
    }

    public static ArmourModifier of(Modifier me, Modifier ri, Modifier hä, Modifier mj, Modifier in) {
        assert me != null;
        assert ri != null;
        assert hä != null;
        assert mj != null;
        assert in != null;

        return new ArmourModifier(me, ri, hä, mj, in);
    }

    public Modifier forArmour(Armour armour) {
        return modifiers.get(armour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArmourModifier that = (ArmourModifier) o;
        return Objects.equals(modifiers, that.modifiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifiers);
    }
}
