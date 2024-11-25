package merp.model.primitives.character;

import javafx.collections.ObservableList;
import merp.LogCallback;
import merp.model.primitives.LogItem;

import java.io.Serializable;

public class IncapacitatedDamage implements Damage, Serializable {

    private String description;
    private int numRounds;

    private IncapacitatedDamage(int numRounds) {
        this.numRounds = numRounds;
        this.description = "Incapacitated for " + numRounds + " rounds";
    }

    public static IncapacitatedDamage of(int numRounds) {
        return new IncapacitatedDamage(numRounds);
    }

    @Override
    public void visit(Character character, ObservableList<Damage> damages, LogCallback logCallback) {
        logCallback.log(LogItem.of(character + " is incapacitated this round"));
        damages.set(damages.indexOf(this), IncapacitatedDamage.of(--numRounds));
    }

    @Override
    public boolean isActive() {
        return numRounds > 0;
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
