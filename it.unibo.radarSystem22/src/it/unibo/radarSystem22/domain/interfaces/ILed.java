package it.unibo.radarSystem22.domain.interfaces;

public interface ILed {
    public void turnOn();
    public void turnOff();
    public boolean getState();
    public void blink(int n);
}
