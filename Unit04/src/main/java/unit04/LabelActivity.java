// Dessa Shapiro
// gooey
package unit04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill; 
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
// import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application {
    public static final int TEXT_SIZE = 50;

    @Override
    // throw exception makes sure we dont have to deal with the checked exeptions somewhere
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();
        // HBox box = new HBox();
        BorderPane bp = new BorderPane(); 
        GridPane gp = new GridPane(); 

        Label top = makeLabel("Top", "Comic Sans MS", TEXT_SIZE, 40, Color.BLUEVIOLET, Pos.CENTER, Color.BLACK);
        Label center = makeLabel("Center", "Times New Roman", TEXT_SIZE, 20, Color.ROSYBROWN, Pos.CENTER_LEFT, Color.LIGHTBLUE);
        Label bottom = makeLabel("Bottom", "Times New Roman", TEXT_SIZE, 20, Color.ROSYBROWN, Pos.CENTER_LEFT, Color.LIGHTBLUE);
        Label left = makeLabel("Left", "Times New Roman", TEXT_SIZE, 20, Color.ROSYBROWN, Pos.CENTER_LEFT, Color.LIGHTBLUE);
        Label right = makeLabel("Right", "Times New Roman", TEXT_SIZE, 20, Color.ROSYBROWN, Pos.CENTER_LEFT, Color.LIGHTBLUE);

        
        // label.setFont(new Font("Comic Sans MS", 150));
        // label.setPadding(new Insets(40));
        // label.setTextFill(Color.BLUEVIOLET);
        // label.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        // label.setAlignment(Pos.CENTER);
        
        bp.setTop(top);
        bp.setCenter(center);
        bp.setBottom(bottom);
        bp.setLeft(left);
        bp.setRight(right);

        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 5; row++) {
                Label gpl = makeLabel(Integer.toString(col) +" "+ Integer.toString(row), "Comic Sans MS", TEXT_SIZE, 40, Color.BLUEVIOLET, Pos.CENTER, Color.BLACK);
                gp.add(gpl, col, row);
            }
        }


        // Label label2 = new Label("Hello World");
        // label2.setFont(new Font(, 150));
        // label2.setPadding(new Insets(40));
        // label2.setTextFill(Color.ROSYBROWN);
        // label2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        // label2.setAlignment(Pos.CENTER);

        box.getChildren().addAll(bp, gp);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("I Am Confused");
        primaryStage.show();
        
    }

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

    public static void main(String[] args) {
        launch(args);
    }
    
}
