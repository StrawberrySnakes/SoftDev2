package model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import petespike.model.GameState;

public class GameStateTest {

    @Test
    public void testEnumValues() {
        GameState[] states = GameState.values();
        assertEquals(4, states.length);
        assertArrayEquals(new GameState[]{GameState.NEW, GameState.IN_PROGRESS, GameState.NO_MOVES, GameState.WON}, states);
    }

    @Test
    public void testGameStateConstants() {
        assertEquals(GameState.NEW, GameState.valueOf("NEW"));
        assertEquals(GameState.IN_PROGRESS, GameState.valueOf("IN_PROGRESS"));
        assertEquals(GameState.NO_MOVES, GameState.valueOf("NO_MOVES"));
        assertEquals(GameState.WON, GameState.valueOf("WON"));
    }
}
    

