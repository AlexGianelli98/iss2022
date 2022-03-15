package it.unibo.radarSystem22.domain.concrete;

import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.models.LedModel;

import java.io.IOException;

public class LedConcrete extends LedModel implements ILed {
    private Runtime rt  = Runtime.getRuntime();

    @Override
    protected void ledActivate(boolean val) {
        try {
            if(val) rt.exec("sudo bash led25GpioTurnOn.sh");
            else rt.exec("sudo bash led25GpioTurnOff.sh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void blink(int n) {
        for (int i = 0; i < 3; i++) {
            try {
                rt.exec("sudo bash led25GpioTurnOn.sh");
                wait(200);
                rt.exec("sudo bash led25GpioTurnOff.sh");
                wait(200);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
