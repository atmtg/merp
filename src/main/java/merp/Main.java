package merp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    ContextMenu contextMenu;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Middle Earth Role Playing Combat System");
        primaryStage.setScene(new Scene(root, 800, 600));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
