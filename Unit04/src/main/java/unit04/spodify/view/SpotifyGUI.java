package unit04.spodify.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SpotifyGUI extends Application{
    public int songsLeft;
    public Label songDisplay= makeLabel("Defult");
    public Label songCount = makeLabel("Songs Left" + songsLeft);


    // A songsLeft field (int) representing how many songs are left on the queue.
    // A songDisplay field (Label) which is a label that will display the current song.
    // A songCount field (Label) which will display the amount of songs left.
    // Create the label fields with the makeLabel method. 



    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
        CornerRadii.EMPTY, BorderStroke.THIN)));
        return label;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button button = new Button("Play Next Song");
        button.maxWidth(Integer.MAX_VALUE);

        VBox box = new VBox(songDisplay, songCount, button);

        primaryStage.setScene(new Scene(box));
        primaryStage.setTitle("High Low Game");
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
