package merp.model.primitives.character;

import javafx.collections.ObservableList;
import merp.LogCallback;

import java.io.Serializable;

public interface Damage extends Serializable {
    void visit(Character character, ObservableList<Damage> damages, LogCallback logCallback);

    boolean isActive();

    String getDescription();
}
