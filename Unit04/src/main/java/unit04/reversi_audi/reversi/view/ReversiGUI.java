package unit04.reversi.view;

import unit04.reversi.model.Reversi;
import unit04.reversi.model.ReversiException;
import unit04.reversi.model.Square;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReversiGUI extends Application{

    private static final Image SQUARE_IMAGE = 
        new Image("file:unit04-botzen67/media/images/reversi/square.png");
    public static final Image BLACK_IMAGE = 
        new Image("file:unit04-botzen67/media/images/reversi/blackpiece.png");
    public static final Image WHITE_IMAGE = 
        new Image("file:unit04-botzen67/media/images/reversi/whitepiece.png");
    public static final Image BLANK_IMAGE = 
        new Image("file:unit04-botzen67/media/images/reversi/blank.png");

    private Reversi board;

    @Override
    public void start(Stage primaryStage) throws Exception {
        board = new Reversi();

        GridPane  boardPane = new GridPane();
        for (int row=0; row < Reversi.ROWS; row++) {
            for (int col=0; col < Reversi.COLS; col++) {
                boardPane.add(makeButton(col, row), col, row);
            }
        }
        primaryStage.setScene(new Scene(boardPane));
        primaryStage.setTitle("Reversi");
        primaryStage.show();
    }

    public void makeMove(int col, int row) {
        System.out.println(board);
        try {
            board.move(col, row);
        } catch(ReversiException re) {
            System.out.println(re.getMessage());
        }
        System.out.println(board);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    private Button makeButton(int row, int col) {
        ImageView squareView = new ImageView(ReversiGUI.BLANK_IMAGE);
        Button button = new Button("",squareView);
        button.setPrefSize(72, 72);
        button.setBackground(new Background(new BackgroundImage(ReversiGUI.SQUARE_IMAGE,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        button.setPadding(new Insets(0));

        button.setOnAction(new MoveMaker(row, col, this));
        
        Square square = board.getSquare(row, col);
        SquareChanger squareChanger = new SquareChanger(squareView);
        square.setOnChange(squareChanger);
        squareChanger.squareChanged(square);

        return button;
    }
}
