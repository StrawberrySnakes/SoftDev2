package unit05.hilo.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 
import unit05.hilo.model.HiLo;

public class HiLoGUI extends Application{
    private HiLo game;
    private TextField text;
    private Label hint;
    private Label availableGuesses;
    
    @Override
    public void start(Stage stage){
        this.game = new HiLo();
        VBox vbox = new VBox();
        
        text = new TextField("Enter a number 1-100.");    
        hint = makeLabel("Game has not started yet.");
        availableGuesses = makeLabel(HiLo.MAX_TRIES + " guesses left.");
        vbox.getChildren().addAll(text, hint, availableGuesses);
        vbox.setPrefWidth(200);

        // controller to model linkage
        text.setOnAction(new TextFieldEventHandler(game, text));
        
        // model to view linkage
        game.register(this);

        stage.setScene(new Scene(vbox));
        stage.setTitle("High Low Game");
        stage.show();
    }

    
    

    public Label getHint(){
        return this.hint;
    }
    public Label getAvailableGuesses(){
        return this.availableGuesses;
    }
    public TextField getText(){
        return this.text;
    }

    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
        CornerRadii.EMPTY, BorderStroke.THIN)));
        return label;
    }

    // update gui when model changes
    @Override
    public void update(HiLo game) {
        String strHint = game.getHint();
        int intAvailableGuesses = availableGuesses;
        boolean gameOver = game.isGameOver();

        // Update the hint label with the latest hint
        this.hint.setText(strHint);
        this.text.setText("");
        
        if(gameOver) {
            text.setDisable(true);
        }
        // Update available guesses label with the remaining guesses
        this.availableGuesses.setText(intAvailableGuesses+ " guesses left.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}






