package merp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import merp.controls.IntegerTextField;
import merp.model.primitives.Modifier;
import merp.model.primitives.Name;
import merp.model.primitives.OffensiveBonus;
import merp.model.primitives.weapon.*;

import java.net.URL;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewAttackController implements Initializable {

    @FXML private TextField nameField;
    @FXML private ComboBox<WeaponBuilder.WeaponBuilderWithNameAndAttackTable> weaponType;
    @FXML private IntegerTextField modifier;
    @FXML private IntegerTextField offensiveBonusField;
    @FXML private CheckBox rangedBox;

    private Optional<Attack> model;

    public NewAttackController() {
        model = Optional.empty();
    }

    public NewAttackController(Attack attack) {
        model = Optional.of(attack);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weaponType.getItems().add(Weapons.BROADSWORD);
        weaponType.getItems().add(Weapons.DAGGER);
        weaponType.getItems().add(Weapons.HAND_AXE);
        weaponType.getItems().add(Weapons.SCIMITAR);
        weaponType.getItems().add(Weapons.SHORT_SWORD);
        weaponType.getItems().add(Weapons.WHIP);

        weaponType.getItems().add(Weapons.CLUB);
        weaponType.getItems().add(Weapons.MAUL);
        weaponType.getItems().add(Weapons.MORNING_STAR);
        weaponType.getItems().add(Weapons.NET);
        weaponType.getItems().add(Weapons.WAR_HAMMER);

        weaponType.getItems().add(Weapons.JAVELIN_NO_SHIELD);
        weaponType.getItems().add(Weapons.JAVELIN_SHIELD);
        weaponType.getItems().add(Weapons.SPEAR_NO_SHIELD);
        weaponType.getItems().add(Weapons.SPEAR_SHIELD);

        weaponType.getItems().add(Weapons.LANCE);
        weaponType.getItems().add(Weapons.HALBERD);

        weaponType.getItems().add(Weapons.BATTLE_AXE);
        weaponType.getItems().add(Weapons.MACE);
        weaponType.getItems().add(Weapons.STAFF);
        weaponType.getItems().add(Weapons.TWO_HAND_SWORD);

        weaponType.getItems().add(Weapons.CROSSBOW);
        weaponType.getItems().add(Weapons.BOLA);
        weaponType.getItems().add(Weapons.COMPOSITE_BOW);
        weaponType.getItems().add(Weapons.LONG_BOW);
        weaponType.getItems().add(Weapons.SHORT_BOW);
        weaponType.getItems().add(Weapons.SLING);

        weaponType.getItems().add(Weapons.BITE);
        weaponType.getItems().add(Weapons.CLAW);
        weaponType.getItems().add(Weapons.GRAPPLE);
        weaponType.getItems().add(Weapons.KICK);
        weaponType.getItems().add(Weapons.TACKLE);

        weaponType.getItems().add(Weapons.BITE_NORMAL);

        if(model.isPresent()) {
            Attack attack = model.get();
            nameField.setText(attack.toString());
            rangedBox.setSelected(attack.isRanged());
            offensiveBonusField.setText(attack.offensiveBonus().value() + "");
            weaponType.getSelectionModel().select(new WeaponBuilder().fromWeapon(attack.weapon()));
            modifier.setText(attack.weapon().generalModifier().value() + "");
        }
    }

    public void doCreateWeapon(ActionEvent actionEvent) {
        Weapon weapon = weaponType.getValue().withGeneralModifier(Modifier.of(modifier.getInt())).build();
        Attack attack = new AttackBuilder().withNameOffensiveBonusAndWeapon(Name.of(nameField.getText()),
                OffensiveBonus.of(offensiveBonusField.getInt()), weapon).withRanged(rangedBox.isSelected()).build();
        Stage stage = (Stage) weaponType.getScene().getWindow();
        Collection<Attack> attacks = (Collection<Attack>)stage.getUserData();
        if(model.isPresent() && attacks.contains(model.get())) {
            attacks.remove(model.get());
        }
        attacks.add(attack);
        stage.close();
    }

}
