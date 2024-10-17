package unit04.reversi.view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveMaker implements EventHandler<ActionEvent> {
    private final int row;
    private final int col;
    private final ReversiGUI gui;

    public MoveMaker(int row, int col, ReversiGUI gui) {
        this.row = row;
        this.col = col;
        this.gui = gui;

    }

    @Override
    public void handle(ActionEvent event) {
        gui.makeMove(col, row);
    }

    
}
