package it.unibo.radarSystem22.domain.interfaces;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public interface ISonar {
    public void activate();
    public void deactivate();
    public boolean isActive();

    public IDistance getDistance();
}
