// Dessa Shapiro
package unit04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class NameTag extends Application implements EventHandler<ActionEvent>{
    public static final int TEXT_SIZE = 50;
    public static final String IMAGE_LOC = "file:media/images/sunflowers.jpg";

    private Label name;
    private TextField field;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(NameTag.IMAGE_LOC);
        // ImageView view = new ImageView(image);


        VBox box = new VBox();
        name = makeLabel("Your Name", "Comic Sans MS", TEXT_SIZE, 40, Color.BLUEVIOLET, Pos.CENTER, Color.BLACK);
        name.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        name.setBackground(new Background(new BackgroundImage(image, null, null, null, null)));

        field = new TextField();
        field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button update = new Button("Update Name Tag");
        update.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Updater updateBtnUpdater = new Updater(field, name);
        update.setOnAction(updateBtnUpdater);
        // update.setOnAction((e) -> name.setText(field.getText()));

        Button clear = new Button("Clear");
        clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        clear.setOnAction(this);
        // clear.setOnAction((e) -> name.setText(""));

        StackPane sp = new StackPane();
        sp.getChildren().addAll(
            new ImageView("file:media/images/emojis/headgreen.png"),
            new ImageView("file:media/images/emojis/mouthdelerious.png"),
            new ImageView("file:media/images/emojis/nosered.png"),
            new ImageView("file:media/images/emojis/eyesblack.png"),
            new ImageView("file:media/images/emojis/browsworried.png")
        );

        box.getChildren().addAll(name, field, update, clear, sp);
        VBox.setVgrow(name, Priority.ALWAYS);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Name Tag");
        primaryStage.show();
        
    }

    /**
     * 
     * @param text
     * @param fontName
     * @param fontSize
     * @param insets
     * @param textFill
     * @param position
     * @param backgroungColor
     * @return
     */
    private static Label makeLabel(String text, String fontName, int fontSize, int insets, Color textFill, Pos position, Color backgroungColor) {
        Label label = new Label(text);
        label.setFont(new Font(fontName, fontSize));
        label.setPadding(new Insets(insets));
        label.setTextFill(textFill);
        label.setAlignment(position);
        label.setBackground(new Background(new BackgroundFill(backgroungColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.DASHED, new CornerRadii(10), BorderStroke.THICK)));
        return label;
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        name.setText("");
    }
}

    
    

