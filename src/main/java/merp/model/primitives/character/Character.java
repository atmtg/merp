package merp.model.primitives.character;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import merp.LogCallback;
import merp.model.primitives.Armour;
import merp.model.primitives.DefensiveBonus;
import merp.model.primitives.LogItem;
import merp.model.primitives.Name;
import merp.model.primitives.weapon.Attack;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Character implements Serializable {
    private Name name;
    private Armour armour;
    private DefensiveBonus defensiveBonus;
    private Collection<Attack> attacks;
    private Boolean hasShield;

    protected Character(Name name, Armour armour, DefensiveBonus defensiveBonus,
                        Collection<Attack> attacks, Boolean hasShield) {
        this.name = name;
        this.armour = armour;
        this.defensiveBonus = defensiveBonus;
        this.attacks = attacks;
        this.hasShield = hasShield;
    }

    public Name getName() {
        return this.name;
    }

    public Armour armour() {
        return this.armour;
    }

    public DefensiveBonus defensiveBonus() {
        return this.defensiveBonus;
    }

    public Collection<Attack> attacks() {
        return this.attacks;
    }

    public boolean hasShield() {
        return this.hasShield;
    }

    public String toString() { return this.name.toString(); }
}
