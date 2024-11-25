package merp;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import merp.controls.IntegerTextField;
import merp.model.primitives.Armour;
import merp.model.primitives.DefensiveBonus;
import merp.model.primitives.Name;
import merp.model.primitives.character.Character;
import merp.model.primitives.character.CharacterBuilder;
import merp.model.primitives.weapon.Attack;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewCharacterController implements Initializable {

    @FXML private TextField nameField;
    @FXML private IntegerTextField dbField;
    @FXML private ComboBox<Armour> armour;
    @FXML private CheckBox hasShield;
    @FXML private ListView<Attack> attackView;

    private Optional<Character> model;

    private ObservableList<Attack> attacks;

    public NewCharacterController() {
        model = Optional.empty();
    }

    public NewCharacterController(Character maybeCharacter) {
        model = Optional.of(maybeCharacter);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.attacks = FXCollections.observableArrayList();
        attacks.addListener(new ListChangeListener<Attack>() {
            @Override
            public void onChanged(Change<? extends Attack> change) {
                attackView.getItems().setAll(attacks);
            }
        });
        attackView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    Attack attack = attackView.getSelectionModel().getSelectedItem();
                    editAttack(attack);
                }
            }
        });
        Arrays.stream(Armour.values()).forEach(a -> armour.getItems().add(a));
        armour.getSelectionModel().select(Armour.NONE);

        if(model.isPresent()) {
            Character character = model.get();
            nameField.setText(character.getName().toString());
            dbField.setText(character.defensiveBonus().value() + "");
            armour.getSelectionModel().select(character.armour());
            hasShield.setSelected(character.hasShield());
            attacks.addAll(character.attacks());
        }
    }

    public void doCreateCharacter(ActionEvent actionEvent) {
        Character character = new CharacterBuilder().withName(Name.of(nameField.getText()))
                .withDefensiveBonus(DefensiveBonus.of(dbField.getInt()))
                .withArmour(armour.getValue())
                .withShield(hasShield.isSelected())
                .withAttacks(attacks)
                .build();
        Stage stage = (Stage) nameField.getScene().getWindow();
        Collection<Character> characters = ((Collection<Character>)stage.getUserData());
        if(model.isPresent() && characters.contains(model.get())) {
            characters.remove(model.get());
        }
        characters.add(character);
        stage.close();
    }

    public void addAttack(ActionEvent actionEvent) throws IOException {
        Parent form = FXMLLoader.load(getClass().getResource("newattack.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add Attack...");
        stage.setScene(new Scene(form, 500, 300));
        stage.setUserData(attacks);

        stage.show();
    }

    public void editAttack(Attack attack) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newattack.fxml"));
        loader.setControllerFactory((Class<?> controllerType) -> {
            try {
                // check constructors of controllerType to see if one takes a Connection:
                for (Constructor<?> c : controllerType.getConstructors()) {
                    if (c.getParameterCount() == 1 && c.getParameterTypes()[0].equals(Attack.class)) {
                        // found matching constructor, invoke it with the connection as parameter:
                        return c.newInstance(attack);
                    }
                }

                // no matching constructor, just invoke default constructor:
                return controllerType.newInstance();
            } catch (Exception e) {
                // fatal...
                throw new RuntimeException(e);
            }
        });
        Parent form = null;
        try {
            form = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Edit Attack...");
        stage.setScene(new Scene(form, 500, 300));
        stage.setUserData(attacks);

        stage.show();
    }
}
