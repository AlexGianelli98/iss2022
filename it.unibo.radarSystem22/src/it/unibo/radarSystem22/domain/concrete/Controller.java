package it.unibo.radarSystem22.domain.concrete;

import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.interfaces.IRadarDisplay;
import it.unibo.radarSystem22.domain.interfaces.ISonar;

public class Controller {
    private final int DLIMIT = 5;

    private ISonar sonar;
    private ILed led;
    private IRadarDisplay radar;

    public Controller(ISonar sonar, ILed led, IRadarDisplay radar) {
        this.sonar = sonar;
        this.led = led;
        this.radar = radar;
    }

    public void run() {
        while( sonar.isActive() ){
            IDistance d = sonar.getDistance();
            if( d.getVal() < DLIMIT)
                led.turnOn();
            else led.turnOff();
            radar.update( ""+d.getVal(), "90");
        }
    }

}
