package unit05.hilo.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import unit05.hilo.model.HiLo;

public class TextFieldEventHandler implements EventHandler<ActionEvent> {

    private HiLo game;
    private TextField text;

    public TextFieldEventHandler(HiLo game, TextField text) {
        this.game = game;
        this.text = text;
    }

    @Override
    public void handle(ActionEvent arg0) {
        try {
            int guess = Integer.parseInt(text.getText());
            game.makeGuess(guess);
        } catch (RuntimeException ex) {
            game.makeGuess(0);
        }
    }
}
 