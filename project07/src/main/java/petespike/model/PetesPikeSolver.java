package petespike.model;

import backtracker.Backtracker;
import backtracker.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a solver for the PetesPike game using backtracking.
 */
public class PetesPikeSolver implements Configuration<PetesPikeSolver> {
    private PetesPike game;
    private List<Move> solutionMoves;

    /**
     * Constructs a new PetesPikeSolver with the given game.
     *
     * @param game The PetesPike game to solve.
     */
    public PetesPikeSolver(PetesPike game) {
        this.game = new PetesPike(game); // Make a copy to avoid modifying the original game
        this.solutionMoves = new ArrayList<>();
    }

    @Override
    public List<PetesPikeSolver> getSuccessors() {
        List<PetesPikeSolver> successors = new ArrayList<>();
        List<Move> possibleMoves = game.getPossibleMoves();

        for (Move move : possibleMoves) {
            PetesPikeSolver successor = new PetesPikeSolver(new PetesPike(game)); // Make a copy of the game state
            successor.makeMove(move); // Make the move on the copied game state
            System.out.println(successor);
        }

        return successors;
    }

    @Override
    public boolean isValid() {
        // Check if the current game state is valid
        return game.getGameState() != GameState.NO_MOVES;
    }

    @Override
    public boolean isGoal() {
        // Check if the current game state is the winning state
        return game.getGameState() == GameState.WON;
    }

    /**
     * Returns the list of moves that constitute the solution.
     *
     * @return
     */
    public List<Move> getSolutionMoves() {
        List<Move> reversedMoves = new ArrayList<>(solutionMoves);
        Collections.reverse(reversedMoves); // Reverse the order of moves
        return reversedMoves;
    }

    /**
     * Makes a move on the game and updates the solution moves list.
     *
     * @param move
     */
    private void makeMove(Move move) {
        try {
            game.makeMove(move); // Make the move on the game state
            solutionMoves.add(move); // Add the move to the solution moves list
        } catch (PetePikeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Solves the PetesPike game using backtracking.
     *
     * @param game The PetesPike game to solve.
     * @return
     */
    public static PetesPikeSolver solve(PetesPike game) {
        Backtracker<PetesPikeSolver> backtracker = new Backtracker<>(false); // Debugging disabled
        PetesPikeSolver initialConfig = new PetesPikeSolver(game);
        return backtracker.solve(initialConfig);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moves:\n");
        for (Move move : solutionMoves) {
            sb.append(move).append("\n");
        }
        sb.append("Game State:\n").append(game);
        return sb.toString();
    }


    public static void main(String[] args) {
        // Create an instance of the PetesPike game with a specific initial state
        PetesPike game = new PetesPike("data\\petes_pike_5_5_2_0.txt");

        // Solve the PetesPike game
        PetesPikeSolver solver = PetesPikeSolver.solve(game);

        // Get the solution moves from the solver
        List<Move> solutionMoves = solver.getSolutionMoves();

        // Print the solution moves
        System.out.println("Solution Moves:");
        for (Move move : solutionMoves) {
            System.out.println(move);
        }
    }
}


