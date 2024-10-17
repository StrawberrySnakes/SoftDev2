package unit03;
// Dessa Shapiro

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit03.toys.ActionFigure;
import unit03.toys.Doll;
import unit03.toys.Robot;

public class ToyTest {
    
    // Tests for doll class
    @Test
    public void testDollConstructor() {
        // Arrange
        String name = "Test Doll";
        double msrp = 19.99;

        // Act
        Doll testDoll = new Doll(name, msrp);

        // Assert
        assertEquals(name, testDoll.getName());
        assertEquals(msrp, testDoll.getMsrp());
        assertNotNull(testDoll.getHairColor());
        assertNotNull(testDoll.getEyeColor());
        assertNotNull(testDoll.getSaying());
        assertEquals(0, testDoll.getPlayCount());
    }

    @Test
    public void testDollPlay() {
        // setup
        String name = "Test Doll";
        double msrp = 19.99;
        Doll testDoll = new Doll(name, msrp);

        // invoke
        for (int i = 0; i < 10; i++) {
            // Play the doll 10 times
            testDoll.play();
            assertEquals(i + 1, testDoll.getPlayCount());
        }

        // analyze
        testDoll.play();
        assertEquals(10, testDoll.getPlayCount());
    }

    @Test
    public void testRobotConstructor() {
        // Setup
        String name = "Test Robot";
        double msrp = 20.99;

        // invoke
        Robot testRobot = new Robot(name, msrp);

        // analyze
        assertEquals(name, testRobot.getName());
        assertEquals(msrp, testRobot.getMsrp());
        assertNotNull(testRobot.getSaying());
    }

    @Test
    public void testChargeRobot() {
        // Setup
        Robot robot = new Robot("TestRobot", 12.99);

        robot.chargeRobot();

        // analyze
        assertEquals(100, robot.getCharage());
    }

    @Test
    public void testPlayWithCharge() {
        // Setup
        Robot robot = new Robot("TestRobot", 12.99);

        // invoke
        robot.chargeRobot();
        robot.play();

        // analyze
        assertEquals(80, robot.getCharage()); // Assuming initial charge was 100 and play decreases it by 20
    }

    @Test
    public void testPlayWithZeroCharge() {
        // Setup
        Robot robot = new Robot("TestRobot", 12.99);


        // invoke
        robot.play();

        // analyze
        assertEquals(0, robot.getCharage());
    }


    @Test
    public void testPlayWithoutKungFuGrip() {
        // Arrange
        ActionFigure actionFigure = new ActionFigure(null, 0);

        // Act
        actionFigure.play();

        // Assert
        assertEquals("ActionFigure is playing action phrase: " + actionFigure.getSaying(), null);
    }

}
