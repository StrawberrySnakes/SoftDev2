package unit04.ttt.view;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import unit04.ttt.model.TicTacToe;
import unit04.ttt.model.TicTacToeStatus;

public class TicTacToeGUI extends Application {

    private TicTacToe ttt;
    private Button[] buttons;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button reset = new Button("RESET");
        reset.setFont(COURIER_NEW);
        reset.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        reset.setOnAction(null);

    }

    public void updateStatus() {
        TicTacToeStatus status = ttt.getStatus();
        switch(status) {

        }
    }
    
}
