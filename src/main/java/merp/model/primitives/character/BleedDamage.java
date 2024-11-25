package merp.model.primitives.character;

import javafx.collections.ObservableList;
import merp.LogCallback;
import merp.model.primitives.HitPointsDamage;
import merp.model.primitives.LogItem;

import java.io.Serializable;

public class BleedDamage implements Damage, Serializable {

    private String description;
    private HitPointsDamage hitPointsDamage;

    private BleedDamage(HitPointsDamage hitPointsDamage) {
        this.hitPointsDamage = hitPointsDamage;
        this.description = "Wounded (" + hitPointsDamage.value() + " HP per round)";
    }

    public static Damage of(HitPointsDamage hitPointsDamage) {
        return new BleedDamage(hitPointsDamage);
    }

    @Override
    public void visit(Character character, ObservableList<Damage> damages, LogCallback logCallback) {
        logCallback.log(LogItem.of(character + " bleeds " + hitPointsDamage.value() + " HP."));
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return description;
    }
}
