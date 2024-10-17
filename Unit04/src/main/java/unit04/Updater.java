package unit04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Updater implements EventHandler<ActionEvent> {
    private final TextField field;
    private final Label label;

    public Updater(TextField field, Label label) {
        this.field = field;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent event) {
        label.setText(field.getText());
    }
    
}
