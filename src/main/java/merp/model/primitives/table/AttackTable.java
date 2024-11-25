package merp.model.primitives.table;

import merp.model.primitives.Armour;
import merp.model.primitives.Roll;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.min;

public abstract class AttackTable implements Serializable {
    protected Map<Armour, Map<Integer, AttackTableEntry>> theTable;

    protected AttackTable() {
        theTable = new HashMap<>();
        Arrays.stream(Armour.values()).forEach(armour -> theTable.put(armour, new HashMap<>()));
    }

    public AttackTableEntry readResult(Armour armour, Roll roll) {
        return theTable.get(armour).get(Math.max(min(roll.value(), max()), 1));
    };

    protected abstract int max();
}
