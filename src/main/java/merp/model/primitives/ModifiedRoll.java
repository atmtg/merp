package merp.model.primitives;

public class ModifiedRoll extends Roll {

    private ModifiedRoll(int value) {
        super(value);
    }

    public static ModifiedRoll of(int value) {
        return new ModifiedRoll(value);
    }
}
