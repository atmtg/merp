package merp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import merp.controls.IntegerTextField;
import merp.model.primitives.HitPointsDamage;
import merp.model.primitives.LogItem;
import merp.model.primitives.Modifier;
import merp.model.primitives.character.BleedDamage;
import merp.model.primitives.character.Character;
import merp.model.primitives.character.DebuffDamage;
import merp.model.primitives.character.IncapacitatedDamage;

public class AttackResultController {

    @FXML
    public IntegerTextField critSPField;
    @FXML
    public IntegerTextField bleedField;
    @FXML
    public IntegerTextField stunnedField;
    @FXML
    public IntegerTextField immobilizedField;
    @FXML
    private Label secondaryCrit;
    @FXML
    private Label primaryCrit;
    @FXML
    private Label hitPointsDamage;
    private LogCallback logCallback;
    private Character victim;
    private ObservableList<Character> characters;
    private DamageCallback damageCallback;

    public void close(ActionEvent actionEvent) {
        StringBuffer critLogText = new StringBuffer();
        if(critSPField.getInt() > 0 || bleedField.getInt() > 0 || stunnedField.getInt() > 0 || immobilizedField.getInt() > 0) {
            critLogText.append(victim + " Takes Critical Injury: ");
            if(critSPField.getInt() > 0) {
                critLogText.append(critSPField.getInt() + " Extra HP. ");
            }
            if(bleedField.getInt() > 0) {
                damageCallback.addDamage(victim, BleedDamage.of(HitPointsDamage.of(bleedField.getInt())));
                critLogText.append("-" + bleedField.getInt() + " HP per Round. ");
            }
            if(stunnedField.getInt() > 0) {
                damageCallback.addDamage(victim, IncapacitatedDamage.of(stunnedField.getInt()));
                critLogText.append("Stunned for " + stunnedField.getInt() + " Round(s). ");
            }
            if(immobilizedField.getInt() > 0) {
                damageCallback.addDamage(victim, DebuffDamage.of(Modifier.of(-immobilizedField.getInt())));
                critLogText.append("-" + immobilizedField.getInt() + " to Activity.");
            }
            logCallback.log(LogItem.of(critLogText.toString()));
        }
        characters.set(characters.indexOf(victim), victim);
        Stage stage = (Stage) this.hitPointsDamage.getScene().getWindow();
        stage.close();
    }

    public void setHitPointsDamage(String hitPointsDamage) {
        this.hitPointsDamage.setText(hitPointsDamage);
    }

    public void setPrimaryCriticalHit(String criticalHit) {
        this.primaryCrit.setText(criticalHit);
    }

    public void setSecondaryCriticalHit(String secondaryCrit) {
        this.secondaryCrit.setText(secondaryCrit);
    }

    public void setLogCallback(LogCallback logCallback) {
        this.logCallback = logCallback;
    }

    public void setCharacters(ObservableList<Character> characters) {
        this.characters = characters;
    }

    public void setVictim(Character victim) {
        this.victim = victim;
    }

    public void setDamageCallback(DamageCallback damageCallback) {
        this.damageCallback = damageCallback;
    }
}
