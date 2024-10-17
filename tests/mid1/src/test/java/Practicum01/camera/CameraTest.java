package Practicum01.camera;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CameraTest {
    @Test
    public void testAnalogCamera() {
        Analog analog = new Analog("Nikkon","ABC-123",LensType.FISHEYE);
        for (int trials = 0; trials < 2; trials++){
            int filmRollSize = 5;
            assertFalse(analog.takePicture());
            analog.loadFilmRoll(filmRollSize);
            for (int picCount = 0; picCount < filmRollSize; picCount++) {
                assertTrue(analog.takePicture());
            }
            assertFalse(analog.takePicture());
        }
    }
    @Test
    public void testDigitalCamera() {
        int picSize = 2;
        Digital digital = new Digital("Sony","567-DEF",LensType.STANDARD,picSize);
        for (int trials = 0; trials < 2; trials++){
            int memoryCardSize = 10;
            assertFalse(digital.takePicture());
            digital.insertMemoryCard(memoryCardSize);
            for (int memUsed = 0; memUsed < memoryCardSize; memUsed += picSize) {
                assertTrue(digital.takePicture());
            }
            assertFalse(digital.takePicture());
        }
    }
}
