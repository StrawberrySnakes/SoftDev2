// Justin Doxsee
// Dessa Shapiro
package petespike.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import backtracker.Backtracker;
import backtracker.Configuration;
import petespike.view.AsciiColorCodes;
import petespike.view.PetesPikeOberver;

public class PetesPike implements Configuration<PetesPike> {
    private static Scanner scanner = new Scanner(System.in);
    public final char MOUNTAINTOP_SYMBOL = 'T';
    public final char EMPTY_SYMBOL = '-';
    public final char PETE_SYMBOL = 'P';
    public final Set<Character> GOAT_SYMBOLS = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8'));
    private int moveCount;
    private char[][] board;
    private int rows;
    private Random random = new Random();
    private int cols;
    private GameState gameState;
    private Map<Character,Position> locations;
    private List<AsciiColorCodes> colors;
    private String filename;
    private PetesPikeOberver observer = null;
    private Position peak;

 
    public PetesPike(String filename) {
        this.filename = filename;
        newBoardMaker(filename);
    }

    public PetesPike(PetesPike petespike) {
        this.cols = petespike.getCols();
        this.rows = petespike.getRows();
        this.board = otherBoardMaker(petespike.getBoard());
        this.gameState = petespike.getGameState();
        this.moveCount = petespike.getMoveCount();
        this.colors = new ArrayList<>(Arrays.asList(AsciiColorCodes.values()));
        this.colors.remove(0);
        this.peak = petespike.getMountainTop();
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void registerObserver(PetesPikeOberver observer) {
        this.observer = observer;
    }

    private void notifyObserver(Position from, Position to) {
        this.observer.pieceMoved(from, to);
    }

    private char[][] otherBoardMaker(char[][] board) {
        char[][] newBoard = new char[this.rows][this.cols];
        Map<Character, Position> locations = new HashMap<>();
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char symbol = board[i][j];
                newBoard[i][j] = symbol;
    
                if (symbol == 'T') {
                    peak = new Position(i, j);
                } else if (GOAT_SYMBOLS.contains(symbol)) {
                    locations.put(symbol, new Position(i, j));
                } else if (symbol == 'P') {
                    locations.put('P', new Position(i, j));
                }
            }
        }
    
        this.locations = locations;
    
        return newBoard;
    }

    public String getFilename() {
        return this.filename;
    }
    
    
    
    public void newBoardMaker() {
        this.newBoardMaker(this.filename);
    }

    public void newBoardMaker(String filename) {
        this.colors = new ArrayList<>(Arrays.asList(AsciiColorCodes.values()));
        this.moveCount = 0;
        this.filename = filename;
        System.out.println(filename);
            try {
                this.colors.remove(0);
                Scanner scanner = new Scanner(new File(filename));
                this.rows = scanner.nextInt();
                this.cols = scanner.nextInt(); 
                scanner.nextLine();
                this.board = new char[rows][cols];
                this.locations = new HashMap<>();

            for (int i = 0; i < this.rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < cols; j++) {
                    this.board[i][j] = line.charAt(j);
                    if (line.charAt(j) == 'T') {
                        this.peak = new Position(i, j);
                    } else if (GOAT_SYMBOLS.contains(line.charAt(j))) {
                        this.board[i][j] = line.charAt(j);
                        this.locations.put(line.charAt(j), new Position(i, j));     
                    } else if (line.charAt(j) == 'P') {
                        this.locations.put('P', new Position(i, j));
                    }
                }
            }

            scanner.close();
            this.gameState = GameState.NEW;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getMoveCount() {return this.moveCount;}
    public int getRows() {return this.rows;}
    public int getCols() {return this.cols;}
    public GameState getGameState() {return this.gameState;}
    public char getSymbolAt(Position position) {return this.board[position.getRow()][position.getCol()];}
    public Position getMountainTop() {return this.peak;}
    public char[][] getBoard() {return this.board;}
    public Map<Character, Position> getLocations() {return this.locations;}
    
    public List<Move> getPossibleMoves() {
        List<Direction> directions = Arrays.asList(Direction.UP, Direction.DOWN, Direction.RIGHT, Direction.LEFT);
        List<Move> moves = new ArrayList<>();
    
        for (Character key : locations.keySet()) {
            Position position = locations.get(key);
            for (Direction direction : directions) {
                Move move = new Move(position, direction);
                if (makeMoveTester(move)) {
                    moves.add(move);
                }
            }
        }
    
        return moves;
    }

    public Move getHint() {
        List<Move> possibleMoves = getPossibleMoves();
        if (!possibleMoves.isEmpty()) {
            int randomIndex = random.nextInt(possibleMoves.size());
            return possibleMoves.get(randomIndex);
        } else {
            return null; // No possible moves
        }
    }
    

    public void makeMove(Move move) throws PetePikeException {
        try{
            if(move.getPosition() == null || this.locations.get(this.getSymbolAt(move.getPosition())) == null) {
                throw new PetePikeException("No piece at location");
            }
        } catch(PetePikeException p) {
            p.getMessage();
            return;
        }
        if(move.getPosition() != null) {
            char symbol = this.getSymbolAt(move.getPosition());
            String output = makeMoveHelper(move);
            if (output == null) {
                this.moveCount++;
                this.gameState = GameState.IN_PROGRESS;
                if (this.locations.get('P').equals(this.getMountainTop())) {
                    this.gameState = GameState.WON;
                } else if (this.getPossibleMoves().size() == 0) {
                    this.gameState = GameState.NO_MOVES;
                }
                if (this.observer != null) {
                    observer.pieceMoved(move.getPosition(), this.locations.get(symbol));
                }
            }
        }
    }

    private Boolean makeMoveTester(Move move) {
            if (move.getDirection() == Direction.LEFT) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = col-1; i>=0; i--) {
                    if(this.GOAT_SYMBOLS.contains(this.board[row][i]) || this.board[row][i] == 'P') {
                        if(i == col-1){
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            } else if(move.getDirection() == Direction.RIGHT) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = col+1; i<=this.cols-1; i++) {
                    
                    if(this.GOAT_SYMBOLS.contains(this.board[row][i]) || this.board[row][i] == 'P') {
                        if(i == col+1){
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            } else if(move.getDirection() == Direction.UP) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = row-1; i>=0; i--) {
                    if(this.GOAT_SYMBOLS.contains(this.board[i][col]) || this.board[i][col] == 'P') {
                        if(i == row-1){
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            } else if(move.getDirection() == Direction.DOWN) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = row+1; i<=this.rows-1; i++) {
                    if(this.GOAT_SYMBOLS.contains(this.board[i][col]) || this.board[i][col] == 'P') {
                        if(i == row+1){
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            }
        return true;
    }

    private String makeMoveHelper(Move move) throws PetePikeException {
        char character = this.getSymbolAt(move.getPosition());
            if (move.getDirection() == Direction.LEFT) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = col-1; i>=0; i--) {
                    if(this.GOAT_SYMBOLS.contains(this.board[row][i]) || this.board[row][i] == 'P') {
                        if(i == col-1){
                            throw new PetePikeException("Not able to move that direction!");
                        }
                        this.board[this.locations.get(character).getRow()][this.locations.get(character).getCol()] = '-';
                        this.board[row][i+1] = character;
                        this.locations.remove(character);
                        this.locations.put(character, new Position(row, i+1));
                        return null;
                    }
                }
                throw new PetePikeException("Cannot move, piece will fall");
            } else if(move.getDirection() == Direction.RIGHT) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = col+1; i<=this.cols-1; i++) {
                    
                    if(this.GOAT_SYMBOLS.contains(this.board[row][i]) || this.board[row][i] == 'P') {
                        if(i == col+1){
                            throw new PetePikeException("Not able to move that direction!");
                        }
                        this.board[this.locations.get(character).getRow()][this.locations.get(character).getCol()] = '-';
                        this.board[row][i-1] = character;
                        this.locations.remove(character);
                        this.locations.put(character, new Position(row, i-1));
                        return null;
                    }
                }
                throw new PetePikeException("Cannot move, piece will fall");
            } else if(move.getDirection() == Direction.UP) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = row-1; i>=0; i--) {
                    if(this.GOAT_SYMBOLS.contains(this.board[i][col]) || this.board[i][col] == 'P') {
                        if(i == row-1){
                            throw new PetePikeException("Not able to move that direction!");
                        }
                        this.board[this.locations.get(character).getRow()][this.locations.get(character).getCol()] = '-';
                        this.board[i+1][col] = character;
                        this.locations.remove(character);
                        this.locations.put(character, new Position(i+1, col));
                        return null;
                    }
                }
                throw new PetePikeException("Cannot move, piece will fall");
            } else if(move.getDirection() == Direction.DOWN) {
                int row = move.getPosition().getRow();
                int col = move.getPosition().getCol();
                for(int i = row+1; i<=this.rows-1; i++) {
                    if(this.GOAT_SYMBOLS.contains(this.board[i][col]) || this.board[i][col] == 'P') {
                        if(i == row+1){
                            throw new PetePikeException("Not able to move that direction!");
                        }
                        this.board[this.locations.get(character).getRow()][this.locations.get(character).getCol()] = '-';
                        this.board[i-1][col] = character;
                        this.locations.remove(character);
                        this.locations.put(character, new Position(i-1, col));
                        return null;
                    }
                }
                throw new PetePikeException("Cannot move, piece will fall");
            }
            return null;
    }

    

    public String commandReturner() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commands:\n");
        sb.append(" help - this help menu\n");
        sb.append(" board - displays current board\n");
        sb.append(" reset - reset current puzzle to start\n");
        sb.append(" new <puzzle_filename> - start a new puzzle\n");
        sb.append(" move <row> <col> <direction> - move the piece at <row> <col>\n    where <direction> one of u(p), d(own), l(eft), r(ight)\n");
        sb.append(" hint - get a valid move, if one exists\n");
        sb.append(" solve - solve the current puzzle\n");
        sb.append(" quit - quit the puzzle\n");
        return sb.toString();
    }

    public void startGame() {
        String input = "";
        System.out.println(commandReturner());
        System.out.println(this);
        while (!input.equals("quit")) {
            System.out.print("\nCommand: ");
            input = scanner.nextLine();
            String[] off_hand = input.split(" ");
            switch (off_hand[0]) {
                case "help":
                    System.out.println(commandReturner());
                    break;
                case "board":
                    System.out.println(this);
                    break;
                case "reset":
                    this.newBoardMaker(this.filename);
                    System.out.println(this);
                    break;
                case "new":
                    if (off_hand.length != 2) {
                        System.out.println("Please enter a file!");
                        break;
                    }
                    this.newBoardMaker(off_hand[1]);
                    System.out.println(this);
                    break;
                case "hint":
                    System.out.println(this.getPossibleMoves().get(random.nextInt(0,this.getPossibleMoves().size())));
                    break;
                case "solve":
                    Backtracker<PetesPike> backtracker = new Backtracker<>(false);
                    PetesPike solution = backtracker.solve(this);
                    this.board = solution.getBoard();
                    System.out.println(this);
                    break;
                case "state":
                        System.out.println(this.gameState);
                        break;
                case "move":
                    if (this.gameState == GameState.WON || this.gameState == GameState.NO_MOVES) {
                        System.out.println("There must be an active game!");
                        break;
                    }
                    if (off_hand.length != 4) {
                        System.out.println("Enter a valid move!");
                        break;
                    }
                    String direction = off_hand[3];
                    switch (direction) {
                        case "d":
                            try {
                                makeMove(new Move(this.locations.get(this.getSymbolAt(new Position(Integer.parseInt(off_hand[1]),Integer.parseInt(off_hand[2])))), Direction.DOWN));
                            } catch (PetePikeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case "u":
                            try {
                                makeMove(new Move(this.locations.get(this.getSymbolAt(new Position(Integer.parseInt(off_hand[1]),Integer.parseInt(off_hand[2])))), Direction.UP));
                            } catch (PetePikeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case "l":
                            try {
                                makeMove(new Move(this.locations.get(this.getSymbolAt(new Position(Integer.parseInt(off_hand[1]),Integer.parseInt(off_hand[2])))), Direction.LEFT));
                            } catch (PetePikeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case "r":
                            try {
                                makeMove(new Move(this.locations.get(this.getSymbolAt(new Position(Integer.parseInt(off_hand[1]),Integer.parseInt(off_hand[2])))), Direction.RIGHT));
                            } catch (PetePikeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                    System.out.println(this);
                    if(this.isGoal()) {
                        this.gameState = GameState.WON;
                        System.out.println("You won!");
                    }
                    if(this.getPossibleMoves().size() == 0 && this.gameState != GameState.WON) {
                        this.gameState = GameState.NO_MOVES;
                        System.out.println("No possible moves!");
                    }
                    break;
                case "moves":
                    System.out.println(this.getPossibleMoves());
                    break;
                default:
                    System.out.println("Enter a valid command");
                    break;
            }
        }
        System.out.println("\nGoodbye!");
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < cols; p++) {
            if (p == 0) {
                sb.append("  ");
            }
            sb.append(p + " ");
        }
        sb.append("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols + 1; j++) {
                if (j == 0) {
                    sb.append(i + " ");
                } else if (GOAT_SYMBOLS.contains(this.board[i][j - 1])){
                    sb.append(colors.get(Character.getNumericValue(this.board[i][j - 1] + 1)).getColorVal() + 'G' + AsciiColorCodes.RESET.getColorVal() + " ");
                } else if (this.board[i][j - 1] == 'T'){
                    sb.append('+' + " ");
                } else if (this.board[i][j - 1] == 'P'){
                    sb.append(AsciiColorCodes.RED.getColorVal() + 'P' + AsciiColorCodes.RESET.getColorVal() + " ");
                } else {
                    sb.append(this.board[i][j - 1] + " ");
                }
            }
            sb.append("\n");
        }
        sb.append("Moves: " + this.moveCount);
        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.print("Puzzle filename: ");
        // String file = scanner.nextLine();
        // PetesPike board = new PetesPike(file);
        PetesPike board1 = new PetesPike("data\\petes_pike_5_5_2_0.txt");

        // System.out.println(board1);
        // System.out.println(board2);
        // System.out.println(board1.getSuccessors());
        board1.startGame();
        // List<Move> pMoves = board1.getPossibleMoves();
        // System.out.println(pMoves);
        // try {
        //     board1.makeMove(pMoves.get(1));
        //     System.out.println(board1.getPossibleMoves().size());
        // } catch (PetePikeException e) {}
        // }
        // List<Move> pMoves = board1.getPossibleMoves();
        // Backtracker<PetesPike> backtracker = new Backtracker<>(true);
        // PetesPike solution = backtracker.solve(board1);
        // System.out.println(solution);
    }




    // Ignore for now, just for the future
    @Override
    public Collection<PetesPike> getSuccessors() {
        ArrayList<PetesPike> successors = new ArrayList<>();
        List<Move> possibleMoves = this.getPossibleMoves();
    
        for (Move move : possibleMoves) {
            try {
                PetesPike successor = new PetesPike(this);
                successor.makeMove(move);
                successors.add(successor);
            } catch (PetePikeException e) {
            }
        }
    
        return successors;
    }
    
    
    

    @Override
    public int hashCode() {
        int result = 0;
        List<Character> keysCopy = new ArrayList<>(this.locations.keySet());
        for (Character key : keysCopy) {
            result += this.locations.get(key).hashCode();
        }
        result = 53 * result;
        return result;
    }

    @Override
    public boolean isValid() {
        return this.gameState != GameState.NO_MOVES || this.gameState == GameState.WON;
    }
    
    

    @Override
    public boolean isGoal() {
        return this.isValid() && this.locations.get('P').equals(this.getMountainTop());
    }
}
