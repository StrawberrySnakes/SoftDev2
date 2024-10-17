package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import petespike.model.PetePikeException;

public class PetePikeExceptionTest {
    @Test
    public void testExceptionMessage() {
        String message = "Test Exception Message";
        PetePikeException exception = new PetePikeException(message);

        assertEquals(message, exception.getMessage());
    }
}

