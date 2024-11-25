package merp.model.primitives.character;

import javafx.collections.ObservableList;
import merp.LogCallback;
import merp.model.primitives.LogItem;
import merp.model.primitives.Modifier;

import java.io.Serializable;

public class DebuffDamage implements Damage, Serializable {

    private String description;
    private Modifier modifier;

    private DebuffDamage(Modifier modifier) {
        this.modifier = modifier;
        this.description = "Action penalty " + modifier.value();
    }

    public static DebuffDamage of(Modifier modifier) {
        return new DebuffDamage(modifier);
    }

    @Override
    public void visit(Character character, ObservableList<Damage> damages, LogCallback logCallback) {
        logCallback.log(LogItem.of(character + " has penalty of " + modifier.value() + " to actions."));
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
