package merp;

import merp.model.primitives.character.Damage;
import merp.model.primitives.character.Character;

public interface DamageCallback {
    void addDamage(Character victim, Damage damage);
}
