package it.unibo.radarSystem22;

import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.mock.LedMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LedTest {

    private ILed led;

    @Before
    public void setUp() {
        led = new LedMock();
    }

    @Test
    public void ledTest() {
        assertFalse(led.getState());

        led.turnOn();

        assertTrue(led.getState());

        led.turnOff();

        assertFalse(led.getState());
    }

}
