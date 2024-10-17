// Justin Doxsee
// Dessa Shapiro
package petespike.view;

import petespike.model.*;

import java.util.*;

import backtracker.Backtracker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class PetesPikeGUI extends Application implements PetesPikeOberver {
    private Position selecPosition;
    private Button selectedCell;
    private PetesPike game = new PetesPike("data\\petes_pike_5_5_2_0.txt");
    private Button[][] buttons;
    private Label moveCountLabel;
    private Label gameStatusField;
    private GridPane grid;
    private PetesPikeSolver solver;

    private String[] puzzleFiles = {"data\\petes_pike_5_7_4_0.txt", "data\\petes_pike_5_5_4_0.txt", "data\\petes_pike_5_5_4_1.txt", "data\\petes_pike_5_5_5_0.txt"}; // Array of filenames
    private int currentFileIndex = 0;

     // Initialize goat images
     private static final Image[] GOAT_IMAGES = {
        new Image("file:data/images/goat1.png"),
        new Image("file:data/images/goat2.png"),
        new Image("file:data/images/goat3.png"),
        new Image("file:data/images/goat4.png"),
        new Image("file:data/images/goat6.png"),
        new Image("file:data/images/goat7.png"),
        new Image("file:data/images/goat8.png"),
        new Image("file:data/images/goat9.png")
    };
    private int lastImageIndexForG = 0;


    private static final Image PEAK_IMAGE = new Image("file:data/images/peak.png");
    private static final Image PLAYER_IMAGE = new Image("file:data/images/player1.png");

    private Map<Character, Image> characterImageMap;
    private ImageView hintImageView;

    @Override
    public void start(Stage primaryStage) {
        game.registerObserver(this);
        this.buttons = new Button[game.getCols()][game.getRows()];
        this.grid = new GridPane();
        for (int i = 0; i < game.getRows(); i++) {
            for (int j = 0; j < game.getCols(); j++) {
                Button cell = new Button();
                cell.setPrefHeight(500 / game.getRows());
                cell.setPrefWidth(600 / game.getCols());
                Position position = new Position(i, j);
                char symbol = game.getSymbolAt(position);
                buttons[i][j] = cell;
                if (symbol == 'T') {
                    // String absolutePath = "C:\\Users\\14153\\RIT\\Year 1\\semester2\\softdev2\\project-team_07\\data\\images\\peak.jpg";
                    // Image imageT = new Image(new File(absolutePath).toURI().toString());
                    // don't know why paths are not working... Ive tired everything
                    // this works https://images.fineartamerica.com/images/artworkimages/medium/3/goats-kids-funny-dabbing-goat-love-goats-eq-designs-transparent.png
                    ImageView imageViewT = new ImageView(PEAK_IMAGE);
                    imageViewT.setFitWidth(cell.getPrefWidth() * 0.8);
                    imageViewT.setFitHeight(cell.getPrefHeight()* 0.8);
                    cell.setGraphic(imageViewT);
                    // cell.setText(String.valueOf(symbol));
                } else if (game.GOAT_SYMBOLS.contains(symbol)) {
                    ImageView imageViewG = getNextImageViewForG();
                    imageViewG.setFitWidth(cell.getPrefWidth() * 0.8);
                    imageViewG.setFitHeight(cell.getPrefHeight() * 0.8);
                    cell.setGraphic(imageViewG);
                    // cell.setText(String.valueOf('G'));

                } else if (symbol == 'P') {
                    ImageView imageViewP = new ImageView(PLAYER_IMAGE);
                    imageViewP.setFitWidth(cell.getPrefWidth() * 0.8);
                    imageViewP.setFitHeight(cell.getPrefHeight() * 0.8);
                    cell.setGraphic(imageViewP);
                    // cell.setText(String.valueOf(symbol));
                }

                cell.setOnAction(event -> {this.selecPosition = position;
                    if (this.selectedCell != null) {
                        this.selectedCell.setStyle("");
                    }
                    this.selectedCell = cell;
                    cell.setStyle("-fx-background-color: yellow;");
                });

                grid.add(cell, j, i);
            }
        }

        Button upButton = new Button("Up");
        upButton.setOnAction(event -> moveMaker(Direction.UP));
        Button downButton = new Button("Down");
        downButton.setOnAction(event -> moveMaker(Direction.DOWN));
        Button leftButton = new Button("Left");
        leftButton.setOnAction(event -> moveMaker(Direction.LEFT));
        Button rightButton = new Button("Right");
        rightButton.setOnAction(event -> moveMaker(Direction.RIGHT));
        Button solveButton = new Button("Solve"); // Create the Solve button
        solveButton.setOnAction(event -> solve()); // Set the action for the Solve button

        VBox buttonBox = new VBox(upButton, downButton, leftButton, rightButton, solveButton);


        loadImages();

        
        

        // Initialize hint image view
        hintImageView = new ImageView();
        hintImageView.setFitWidth(100); // Set the width to match the hint button
        hintImageView.setPreserveRatio(true);
        // Hint button
        Button hintButton = new Button("Hint");
        hintButton.setOnAction(e -> getHint());
        VBox hintBox = new VBox(hintButton, hintImageView);
        buttonBox.getChildren().add(hintBox);





        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> {
            resetGame();
        });

        TextField puzzleFileField = new TextField();
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> newGame());

        HBox topBar = new HBox(resetButton, puzzleFileField, newGameButton);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(grid);
        borderPane.setRight(buttonBox);
        borderPane.setTop(topBar);

        this.moveCountLabel = new Label("Moves: "+game.getMoveCount() + "");
        this.gameStatusField = new Label("New Game Started!");
        
        HBox bottomBar = new HBox(gameStatusField, new Region(), moveCountLabel);
        HBox.setHgrow(bottomBar.getChildren().get(1), Priority.ALWAYS);
        borderPane.setBottom(bottomBar);

        Scene scene = new Scene(borderPane, 600, 500);
        primaryStage.setTitle("Pete's Pike Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Solve related stuff
    private void solve() {
        // Check if the game is already won or there are no moves left
        if (game.getGameState() == GameState.WON || game.getGameState() == GameState.NO_MOVES) {
            gameStatusField.setText("Game is over! No need to solve.");
            return;
        }
        // Create a solver instance with the current game state
        Backtracker<PetesPike> backtracker = new Backtracker<>(false);
        PetesPike solution = backtracker.solve(this.game);

        if (solution == null) {
            gameStatusField.setText("No solution found.");
        } else {
            solution.setFilename(this.game.getFilename());
            this.game = solution;
            initializeGrid();
        }
    }

    // Method to apply solution moves to the game
    private void applySolutionMoves(List<Move> moves) {
        for (Move move : moves) {
            // moveMaker(move.getDirection());
            // just to test
            gameStatusField.setText(move.toString());
            try {
                game.makeMove(move);
            } catch (PetePikeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that gets a hint
     */
    private void getHint() {
    if (game.getGameState() == GameState.WON || game.getGameState() == GameState.NO_MOVES) {
        gameStatusField.setText("Game is over! No hints available.");
        return;
        }
    Move hintMove = game.getHint();
    if (hintMove != null) {
        Position hintPosition = hintMove.getPosition();
        Direction hintDirection = hintMove.getDirection();
        char hintCharacter = game.getSymbolAt(hintPosition);
        Image hintImage = characterImageMap.get(hintCharacter);
        if (hintImage != null) {
            hintImageView.setImage(hintImage);
            // Show direction below the picture
            gameStatusField.setText("Direction: " + hintDirection);
        } else {
            gameStatusField.setText("No hint image available.");
        }
    } else {
        gameStatusField.setText("No hints available.");
    }
}

    private void loadImages() {
        characterImageMap = new HashMap<>();
        // Load images for each character hint and associate them with characters
        characterImageMap.put('0', GOAT_IMAGES[0]);
        characterImageMap.put('1', GOAT_IMAGES[1]);
        characterImageMap.put('2', GOAT_IMAGES[2]);
        characterImageMap.put('3', GOAT_IMAGES[3]);
        characterImageMap.put('4', GOAT_IMAGES[4]);
        characterImageMap.put('P', PLAYER_IMAGE);
        characterImageMap.put('T', PEAK_IMAGE);


        // Add mappings for other characters as needed
    }

    // method to rotate through goat pictures
    private ImageView getNextImageViewForG() {
        // if (lastImageIndexForG == 0) {
        if(lastImageIndexForG > 9) {
            lastImageIndexForG = 0;
        }
            ImageView thing = new ImageView(GOAT_IMAGES[lastImageIndexForG]);
            lastImageIndexForG++;
            return thing;
        // } else {
        //     ImageView thing = new ImageView(GOAT_IMAGES[lastImageIndexForG+1]);
        //     lastImageIndexForG++;
        //     return thing;
        // }
        

    }

    // private void clearHintStyle() {
    //     for (Button[] row : buttons) {
    //         for (Button button : row) {
    //             button.setStyle("");
    //         }
    //     }
    // }

    private void moveMaker(Direction direction) {
        if (this.game.getGameState() == GameState.WON || this.game.getGameState() == GameState.NO_MOVES) {
            this.gameStatusField.setText("Game is over! Please start a new game!");
        } else {
            try {
                game.makeMove(new Move(this.selecPosition, direction));
            } catch (PetePikeException e) {
                this.gameStatusField.setText(e.getMessage());
            } 
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initializeGrid() {
        grid.getChildren().clear();

        for (int i = 0; i < game.getRows(); i++) {
            for (int j = 0; j < game.getCols(); j++) {
                Button cell = new Button();
                cell.setPrefHeight(500 / game.getRows());
                cell.setPrefWidth(600 / game.getCols()); 
                Position position = new Position(i, j);
                // this.buttons = new Button[game.getCols()][game.getRows()];

                char symbol = game.getSymbolAt(position);
                buttons[i][j] = cell;
                if (symbol == 'T') {
                    ImageView imageViewT = new ImageView(PEAK_IMAGE);
                    imageViewT.setFitWidth(cell.getPrefWidth() * 0.8);
                    imageViewT.setFitHeight(cell.getPrefHeight() * 0.8);
                    cell.setGraphic(imageViewT);
                } else if (game.GOAT_SYMBOLS.contains(symbol)) {
                    ImageView imageViewG = getNextImageViewForG();
                    imageViewG.setFitWidth(cell.getPrefWidth() * 0.8);
                    imageViewG.setFitHeight(cell.getPrefHeight() * 0.8);
                    cell.setGraphic(imageViewG);
                } else if (symbol == 'P') {
                    ImageView imageViewP = new ImageView(PLAYER_IMAGE);
                    imageViewP.setFitWidth(cell.getPrefWidth() * 0.8);
                    imageViewP.setFitHeight(cell.getPrefHeight() * 0.8);
                    cell.setGraphic(imageViewP);
                }

                cell.setOnAction(event -> {this.selecPosition = position;
                    if (this.selectedCell != null) {
                        this.selectedCell.setStyle("");
                    }
                    this.selectedCell = cell;
                    cell.setStyle("-fx-background-color: yellow;");
                });

                grid.add(cell, j, i);
            }
        }
    }

    private void newGame() {
        lastImageIndexForG = 0;
        String filename = puzzleFiles[currentFileIndex];
        currentFileIndex = (currentFileIndex + 1) % puzzleFiles.length;
        game.newBoardMaker(filename);
        initializeGrid();
        gameStatusField.setText("New board loaded.");

        moveCountLabel.setText("Moves: "+game.getMoveCount() + "");

        // lastImageIndexForG = 0;

        


        // game.newBoardMaker(filename);

        // initializeGrid();

        // gameStatusField.setText("New board loaded.");

        // moveCountLabel.setText("Moves: "+game.getMoveCount() + "");
    }

    private void resetGame() {
        lastImageIndexForG = 0;

        game.newBoardMaker(game.getFilename());

        initializeGrid();

        gameStatusField.setText("Game reset.");

        moveCountLabel.setText("Moves: "+game.getMoveCount() + "");
    }

    @Override
    public void pieceMoved(Position from, Position to) {
        char symbol = game.getSymbolAt(to);
        Button toButton = buttons[to.getRow()][to.getCol()];
        Button fromButton = buttons[from.getRow()][from.getCol()];
        hintImageView.setImage(null);

        if (game.GOAT_SYMBOLS.contains(symbol)) {
            ImageView imageViewG = getNextImageViewForG();
            imageViewG.setFitWidth(toButton.getPrefWidth() * 0.8);
            imageViewG.setFitHeight(toButton.getPrefHeight() * 0.8);
            toButton.setGraphic(imageViewG);
        } else if (symbol == 'P') {
            ImageView imageViewP = new ImageView(PLAYER_IMAGE);
            imageViewP.setFitWidth(toButton.getPrefWidth() * 0.8);
            imageViewP.setFitHeight(toButton.getPrefHeight() * 0.8);
            toButton.setGraphic(imageViewP);
        } else {
            toButton.setGraphic(null); // Clear graphic if no piece
        }

        fromButton.setGraphic(null); // Clear graphic from previous position
        fromButton.setStyle(""); // Clear selection style

        // Update move count label
        moveCountLabel.setText("Moves: "+game.getMoveCount());

        // Update game status field based on game state
        if (game.getGameState() == GameState.WON) {
            gameStatusField.setText("You have climbed the peak!");
        } else if (game.getGameState() == GameState.NO_MOVES) {
            gameStatusField.setText("No possible moves!");
        } else {
            gameStatusField.setText("Good Move!");
        }
    }

}

