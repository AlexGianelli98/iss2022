package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.models.LedModel;
import it.unibo.radarSystem22.domain.utils.ColorsOut;

public class LedMock extends LedModel implements ILed {

    private boolean state;

    public LedMock() {
        state = false;
    }

    protected void showState(){
        ColorsOut.outappl("LedMock state=" + getState(), ColorsOut.MAGENTA);
    }

    @Override
    protected void ledActivate(boolean val) {
        showState();
    }

    @Override
    public void turnOn() {
        state = true;
    }

    @Override
    public void turnOff() {
        state = false;
    }

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public void blink(int n) {
        for (int i = 0; i < 3; i++) {
            try {
                state = true;
                wait(200);
                state = false;
                wait(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
