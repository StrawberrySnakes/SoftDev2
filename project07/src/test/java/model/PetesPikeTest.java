package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import petespike.model.*;

public class PetesPikeTest {

    public PetesPike petesPike = new PetesPike("data\\petes_pike_5_5_2_0.txt");


    @Test
    public void testNewBoardMaker() {
        // Test if newBoardMaker method properly resets the game state
        petesPike.newBoardMaker("data\\new_puzzle.txt");
        assertEquals(GameState.NEW, petesPike.getGameState());
    }

    @Test
    public void testMakeMoveValidMove() {
        // Test a valid move
        Move move = new Move(new Position(0, 4), Direction.LEFT);
        try {
            petesPike.makeMove(move);
            assertEquals(1, petesPike.getMoveCount());
        } catch (PetePikeException e) {
            fail("Exception not expected for valid move.");
        }
    }

    // @Test
    // public void testMakeMoveInvalidMove() {
    //     // Test an invalid move
    //     Move move = new Move(new Position(0, 0), Direction.UP);
    //     try {
    //         petesPike.makeMove(move);
    //         fail("Expected PetePikeException for invalid move.");
    //     } catch (PetePikeException e) {
    //         // Exception is expected
    //     }
    // }

    @Test
    public void testGetPossibleMoves() {
        // Test if getPossibleMoves returns the correct number of moves
        assertEquals(2, petesPike.getPossibleMoves().size());
    }

    @Test
    public void testGetHint() {
        // Test if getHint returns valid move
        assertNotNull(petesPike.getHint());
    }

    @Test
    public void testToString() {
        // Test if toString method returns a non-empty string
        assertNotNull(petesPike.toString());
    }
}

    

