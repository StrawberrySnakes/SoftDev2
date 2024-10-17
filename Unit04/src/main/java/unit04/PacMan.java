package unit04;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PacMan extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();
        Button start = makeButton("Start", "file:media/sounds/start.wav",
        "file:media/images/smb/goomba.png");
        Button chomp = makeButton("Chomp", "file:media/sounds/chomp.wav",
        "file:media/images/smb/jump.png");
        Button eat = makeButton("Eat", "file:media/sounds/eat.wav", 
        "file:media/images/smb/rock.png");
        Button end = makeButton("End", "file:media/sounds/end.wav", 
        "file:media/images/smb/question.png");

        box.getChildren().addAll(start, chomp, eat, end);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Player");
        primaryStage.show();


    }
    private static Button makeButton(String txt, String path, String graphicPath) {
        Button button = new Button(txt, new ImageView(graphicPath));
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        String uri = new File(path).toURI().toString();
        Media media = new Media(uri);
        MediaPlayer player = new MediaPlayer(media);
        button.setOnAction(new SoundPlayer(player));
        return button;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
} 
