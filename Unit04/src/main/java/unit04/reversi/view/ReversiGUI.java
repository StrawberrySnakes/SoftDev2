// Dessa Shapiro
package unit04.reversi.view;

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
import unit04.reversi.model.Reversi;
import unit04.reversi.model.ReversiException;
import unit04.reversi.model.Square;


public class ReversiGUI extends Application{
    public static final Image SQUARE_IMAGE = new Image("file:media/images/reversi/square.png");
    public static final Image BLACK_IMAGE = new Image("file:media/images/reversi/blackpiece.png");
    public static final Image WHITE_IMAGE = new Image("file:media/images/reversi/whitepiece.png");
    public static final Image BLANK_IMAGE = new Image("file:media/images/reversi/blank.png");

    private Reversi board;


    @Override
    public void start(Stage primaryStage) throws Exception {
        board = new Reversi();
        System.out.println(board);
        

        GridPane boardPane = new GridPane();
        for (int col=0; col<Reversi.ROWS; col++) {
            for (int row=0; row<Reversi.ROWS; row++) {
                boardPane.add(makeButton(col, row), col, row);
            }
        }

        primaryStage.setScene(new Scene(boardPane));
        primaryStage.setTitle("Reversi");
        primaryStage.show();
        // makeMove(5, 3);
    }

    public void makeMove(int row, int col) {
        try {
            board.move(row, col);
        } catch(ReversiException re) {
            System.out.println(re.getMessage());
        }
        System.out.println(board);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 
     * @param col
     * @param row
     * @return
     */
    private Button makeButton(int col, int row) {
        ImageView squareView = new ImageView(ReversiGUI.BLANK_IMAGE);
        Button button = new Button("", squareView);
        button.setPrefSize(72, 72);
        button.setBackground(new Background(new BackgroundImage(ReversiGUI.SQUARE_IMAGE, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        button.setPadding(new Insets(0));

        button.setOnAction(new MoveMaker(row, col, this));

        Square square = board.getSquare(row, col);
        square.setOnChange(new SquareChanger(squareView));
        
        // switch(square.getOccupyingColor()) {
        //     case BLACK:
        //         squareView.setImage(BLACK_IMAGE);
        //         break;
        //     case WHITE:
        //         squareView.setImage(WHITE_IMAGE);
        //         break;
        //     default:
        //         squareView.setImage(BLANK_IMAGE);
        //         break; 
        // }

        return button;
    }
    
}
