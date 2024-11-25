package merp;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import merp.model.primitives.LogItem;
import merp.model.primitives.character.Character;
import merp.model.primitives.character.Damage;

import java.net.URL;
import java.util.ResourceBundle;

public class HealController implements Initializable {
    @FXML private TableColumn columnDamage;
    @FXML private TableView<Damage> damageTable;

    private LogCallback logCallback;
    private ObservableList<Damage> damages;
    private Character character;
    private ObservableList<Character> characters;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addDeleteButtonToTable();
    }

    private void addDeleteButtonToTable() {
        columnDamage.setCellValueFactory(new PropertyValueFactory<Damage, String>("description"));

        TableColumn<Damage, Void> colBtn = new TableColumn("");
        colBtn.setPrefWidth(30);

        Callback<TableColumn<Damage, Void>, TableCell<Damage, Void>> cellFactory = new Callback<TableColumn<Damage, Void>, TableCell<Damage, Void>>() {
            @Override
            public TableCell<Damage, Void> call(final TableColumn<Damage, Void> param) {
                final TableCell<Damage, Void> cell = new TableCell<Damage, Void>() {

                    private final Button btn = new Button("X");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Damage damage = getTableView().getItems().get(getIndex());
                            damages.remove(damage);
                            logCallback.log(LogItem.of(character + " was Healed from their Injury " + damage));
                            characters.set(characters.indexOf(character), character);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : btn);
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        damageTable.getColumns().add(colBtn);
    }

    public void close(ActionEvent actionEvent) {
        ((Stage)damageTable.getScene().getWindow()).close();
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setCharacters(ObservableList<Character> characters) {
        this.characters = characters;
    }

    public void setDamages(ObservableList<Damage> damages) {
        this.damages = damages;
        damageTable.getItems().setAll(damages);

        this.damages.addListener(new ListChangeListener<Damage>() {
            @Override
            public void onChanged(Change<? extends Damage> change) {
                damageTable.getItems().setAll(damages);
            }
        });
    }

    public void setLogCallback(LogCallback logCallback) {
        this.logCallback = logCallback;
    }
}
