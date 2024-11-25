package merp;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import merp.model.primitives.LogItem;
import merp.model.primitives.character.Character;
import merp.model.primitives.character.Damage;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable, LogCallback, DamageCallback {

    @FXML private TableView<Character> characterTable;
    @FXML private TableColumn<Character, String> columnName;

    private ObservableList<Character> characters;
    private ObservableList<LogItem> logItems;
    private ObservableMap<Character, ObservableList<Damage>> damages;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.damages = FXCollections.observableHashMap();
        this.logItems = FXCollections.observableArrayList();

        this.characters = FXCollections.observableArrayList();
        characters.addListener(new ListChangeListener<Character>() {
            @Override
            public void onChanged(Change<? extends Character> change) {
                characterTable.getItems().setAll(characters);
            }
        });
        columnName.setCellValueFactory(new PropertyValueFactory<Character, String>("name"));

        addShootButtonToTable();
        addAttackButtonToTable();
        addHealButtonToTable();
        addDeleteButtonToTable();

        characterTable.setRowFactory(tv -> {
            TableRow<Character> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Character rowData = row.getItem();
                    editCharacter(rowData);
                }
            });
            return row ;
        });
        try {
            InputStream in = new FileInputStream("merp.bin");
            ObjectInputStream stream = new ObjectInputStream(in);
            List<Character> tempCharacters = (List<Character>) stream.readObject();
            characters.addAll(tempCharacters);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addShootButtonToTable() {
        addButtonToTable("Shoot...",
                character -> shoot(character),
                character -> character.attacks().stream().anyMatch(a -> a.isRanged()));
    }

    private void addAttackButtonToTable() {
        addButtonToTable("Brawl...",
                character -> attack(character),
                character -> character.attacks().stream().anyMatch(a -> !a.isRanged()));
    }

    private void addHealButtonToTable() {
        addButtonToTable("Heal...",
                character -> heal(character),
                character -> isDamaged(character));
    }

    private void addButtonToTable(String title, CharacterOperation operation, CharacterShouldHaveButton shouldHaveButton) {
        TableColumn<Character, Void> colBtn = new TableColumn("");
        colBtn.setPrefWidth(90);
        colBtn.setStyle("-fx-alignment: CENTER");
        Callback<TableColumn<Character, Void>, TableCell<Character, Void>> cellFactory = new Callback<TableColumn<Character, Void>, TableCell<Character, Void>>() {
            @Override
            public TableCell<Character, Void> call(final TableColumn<Character, Void> param) {
                final TableCell<Character, Void> cell = new TableCell<Character, Void>() {

                    private final Button btn = new Button(title);
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Character character = getTableView().getItems().get(getIndex());
                            try {
                                operation.operate(character);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty || !shouldHaveButton.shouldHaveButton(getTableView().getItems().get(getIndex())) ? null : btn);
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        characterTable.getColumns().add(colBtn);
    }

    private void addDeleteButtonToTable() {
        TableColumn<Character, Void> colBtn = new TableColumn("");
        colBtn.setPrefWidth(30);

        Callback<TableColumn<Character, Void>, TableCell<Character, Void>> cellFactory = new Callback<TableColumn<Character, Void>, TableCell<Character, Void>>() {
            @Override
            public TableCell<Character, Void> call(final TableColumn<Character, Void> param) {
                final TableCell<Character, Void> cell = new TableCell<Character, Void>() {

                    private final Button btn = new Button("X");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Character data = getTableView().getItems().get(getIndex());
                            characters.remove(data);
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
        characterTable.getColumns().add(colBtn);
    }

    @FXML
    public void handleExitAction(javafx.event.ActionEvent actionEvent) {
        try {
            OutputStream out = new FileOutputStream("merp.bin");
            ObjectOutputStream stream = new ObjectOutputStream(out);
            List<Character> tempCharacters = new ArrayList<>();
            tempCharacters.addAll(characters);
            stream.writeObject(tempCharacters);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void newCharacter(ActionEvent actionEvent) throws IOException {
        Parent form = FXMLLoader.load(getClass().getResource("newchar.fxml"));
        Stage stage = new Stage();
        stage.setTitle("New Character");
        stage.setScene(new Scene(form, 500, 400));
        stage.setUserData(characters);

        stage.show();
    }

    public void editCharacter(Character character) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newchar.fxml"));
        loader.setControllerFactory((Class<?> controllerType) -> {
            try {
                // check constructors of controllerType to see if one takes a Connection:
                for (Constructor<?> c : controllerType.getConstructors()) {
                    if (c.getParameterCount() == 1 && c.getParameterTypes()[0].equals(Character.class)) {
                        // found matching constructor, invoke it with the connection as parameter:
                        return c.newInstance(character);
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
        stage.setTitle("Edit Character");
        stage.setScene(new Scene(form, 550, 400));
        stage.setUserData(characters);

        stage.show();
    }

    private void shoot(Character character) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("shoot.fxml"));
        Parent form = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Shoot...");
        stage.setScene(new Scene(form, 600, 400));

        ShootController controller = loader.getController();
        controller.setCharacters(characters);
        controller.setAttacker(character);
        controller.setLogCallback(this);
        controller.setDamageCallback(this);

        stage.show();
    }

    private void attack(Character character) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("attack.fxml"));
        Parent form = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Brawl...");
        stage.setScene(new Scene(form, 500, 500));

        AttackController controller = loader.getController();
        controller.setCharacters(characters);
        controller.setAttacker(character);
        controller.setLogCallback(this);
        controller.setDamageCallback(this);

        stage.show();
    }

    private void heal(Character character) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("heal.fxml"));
        Parent form = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Heal...");
        stage.setScene(new Scene(form, 500, 500));

        HealController controller = loader.getController();
        controller.setCharacter(character);
        controller.setCharacters(characters);
        controller.setDamages(this.damages.get(character));
        controller.setLogCallback(this);

        stage.show();
    }

    public void warLog(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("log.fxml"));
        Parent form = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Combat Log");
        stage.setScene(new Scene(form, 800, 1000));

        LogController controller = loader.getController();
        controller.registerLogListener(logItems);

        stage.show();
    }

    @Override
    public void log(LogItem logItem) {
        logItems.add(logItem);
    }

    public void newRound(ActionEvent actionEvent) {
        this.log(LogItem.of("---------- New Round ----------"));
        checkDamages();
    }

    @Override
    public void addDamage(Character character, Damage damage) {
        if(!this.damages.containsKey(character)) {
            this.damages.put(character, FXCollections.observableArrayList());
        }
        this.damages.get(character).add(damage);
    }

    public void checkDamages() {
        this.damages.keySet().stream().forEach(character -> {
            this.damages.get(character).stream().forEach(damage -> damage.visit(character, this.damages.get(character), this));
            this.damages.get(character).removeIf(damage -> !damage.isActive());
            });
        };

    public boolean isDamaged(Character character) {
        return this.damages.containsKey(character) && !this.damages.get(character).isEmpty();
    }

    private interface CharacterOperation {
        void operate(Character character) throws IOException;
    }

    private interface CharacterShouldHaveButton {
        boolean shouldHaveButton(Character character);
    }
}