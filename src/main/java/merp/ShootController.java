package merp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import merp.controls.IntegerTextField;
import merp.model.primitives.AttackResult;
import merp.model.primitives.LogItem;
import merp.model.primitives.Modifier;
import merp.model.primitives.Roll;
import merp.model.primitives.character.Character;
import merp.model.primitives.weapon.Attack;
import merp.model.primitives.weapon.Weapon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ShootController implements Initializable {
    @FXML private Button shootButton;
    @FXML private Label rangeHelp;
    @FXML private IntegerTextField rangeField;
    @FXML private ComboBox<Character> opponents;
    @FXML private ComboBox<Attack> attacks;
    @FXML private IntegerTextField roll;
    @FXML private IntegerTextField oppParryField;
    @FXML private CheckBox hurtBox;
    @FXML private CheckBox drawBox;
    @FXML private IntegerTextField extraField;
    private LogCallback logCallback;
    private Character attacker;
    private ObservableList<Character> characters;
    private DamageCallback damageCallback;
    private Modifier rangeModifier;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shootButton.setDisable(true);
        oppParryField.setDisable(true);
        rangeModifier = Modifier.of(0);

        rangeField.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            boolean disabled = false;
            Weapon weapon = attacks.getValue().weapon();
            String rangeHelpText = "";
            if(newValue.length() == 0) {
                rangeHelpText = "";
            } else {
                int val = Integer.parseInt(newValue);
                if (val <= weapon.baseRange().range()) {
                    rangeHelpText = "Short Range (±0)";
                    rangeModifier = Modifier.of(0);
                } else if (val <= weapon.baseRange().range() * 2) {
                    rangeHelpText = "Normal Range (-25)";
                    rangeModifier = Modifier.of(-25);
                } else if (val <= weapon.baseRange().range() * 3) {
                    rangeHelpText = "Long Range (-50)";
                    rangeModifier = Modifier.of(-50);
                } else if (val <= weapon.baseRange().range() * 4) {
                    rangeHelpText = "Maximum Range (-75)";
                    rangeModifier = Modifier.of(-75);
                } else {
                    rangeHelpText = "Out of Range";
                    disabled = true;
                }
            }
            rangeHelp.setText(rangeHelpText);
            shootButton.setDisable(disabled);
        }));
    }

    public void doShoot(ActionEvent actionEvent) throws IOException {
        Roll unmodifiedRoll = Roll.of(roll.getInt());
        Character opponent = opponents.getValue();
        Weapon weapon = attacks.getValue().weapon();
        if(weapon.isFumble(unmodifiedRoll)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Attack!");
            alert.setContentText("This Roll Resulted in a Fumble. Please Roll against the Fumble Table!");
            alert.show();
            return;
        }
        Roll modifiedRoll = weapon.applyModifiers(unmodifiedRoll, opponent.armour());
        modifiedRoll = modifiedRoll.modifyWith(Modifier.of(attacks.getValue().offensiveBonus().value()));
        modifiedRoll = modifiedRoll.modifyWith(Modifier.of(-opponent.defensiveBonus().value()));
        modifiedRoll = modifiedRoll.modifyWith(rangeModifier);
        modifiedRoll = modifiedRoll.modifyWith(Modifier.of(-20 * (hurtBox.isSelected() ? 1 : 0)));
        modifiedRoll = modifiedRoll.modifyWith(Modifier.of(-30 * (drawBox.isSelected() ? 1 : 0)));
        modifiedRoll = modifiedRoll.modifyWith(Modifier.of(-oppParryField.getInt()));
        modifiedRoll = modifiedRoll.modifyWith(Modifier.of(extraField.getInt()));
        AttackResult result = weapon.wieldAgainst(modifiedRoll, opponent.armour());

        LogItem logItem = createLogText(opponent, weapon, result);
        logCallback.log(logItem);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("attackresult.fxml"));
        Parent form = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Attack!");
        stage.setScene(new Scene(form, 500, 500));

        AttackResultController controller = loader.getController();
        controller.setHitPointsDamage(result.hitPointsDamage().value() + " HP");
        controller.setPrimaryCriticalHit(result.primaryCriticalHit().toString());
        controller.setSecondaryCriticalHit(result.secondaryCriticalHit().toString());
        controller.setLogCallback(logCallback);
        controller.setVictim(opponent);
        controller.setCharacters(characters);
        controller.setDamageCallback(damageCallback);

        stage.show();
    }

    private LogItem createLogText(Character opponent, Weapon weapon, AttackResult result) {
        StringBuffer logText = new StringBuffer();
        logText.append(attacker + " Shoots/Throws Against " + opponent + " with " + weapon);
        if(result.hitPointsDamage().value() <= 0) {
            logText.append(" but Misses!");
        } else {
            logText.append(" and does " + result.hitPointsDamage().value() + " HP of Damage. ");
            if(!result.primaryCriticalHit().toString().equals("-")) {
                logText.append("In Addition the Hit Results in a " + result.primaryCriticalHit().toString() + " Primary Critical Injury");
                if(!result.secondaryCriticalHit().toString().equals("-")) {
                    logText.append(" och en " + result.secondaryCriticalHit().toString() + " Secondary Critical Injury.");
                } else {
                    logText.append(".");
                }
            }
        }
        return LogItem.of(logText.toString());
    }
    
    public void setCharacters(ObservableList<Character> characters) {
        this.characters = characters;
        opponents.getItems().addAll(characters);
    }

    public void setAttacker(Character character) {
        this.attacker = character;
        attacks.getItems().addAll(character.attacks().stream().filter(a ->
                a.isRanged()).collect(Collectors.toList()));
        attacks.getSelectionModel().select(attacks.getItems().get(0));
    }

    public void setLogCallback(LogCallback logCallback) {
        this.logCallback = logCallback;
    }

    public void setDamageCallback(DamageCallback damageCallback) { this.damageCallback = damageCallback; }

    public void opponentSelected(ActionEvent actionEvent) {
        this.shootButton.setDisable(false);
        this.oppParryField.setDisable(!this.opponents.getValue().hasShield());
    }
}
