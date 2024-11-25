package merp;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import merp.model.primitives.LogItem;

public class LogController {

    @FXML
    private ListView<LogItem> logTable;

    public void registerLogListener(ObservableList<LogItem> logItems) {
        logItems.addListener(new ListChangeListener<LogItem>() {
            @Override
            public void onChanged(Change<? extends LogItem> change) {
                logTable.getItems().setAll(logItems);
            }
        });
    }
}
