package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.concrete.Distance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.models.SonarModel;
import it.unibo.radarSystem22.domain.utils.BasicUtils;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public class SonarMock extends SonarModel implements ISonar {
    private int delta = 1;

    @Override
    protected void sonarSetUp() {
        curVal = new Distance(90);
    }

    @Override
    protected void sonarProduce() {
        if (DomainSystemConfig.testing) {
            updateDistance(DomainSystemConfig.testingDistance);
            stopped = true;  //one shot
        } else {
            int v = curVal.getVal() - delta;
            updateDistance(v);
            stopped = (v <= 0);
            BasicUtils.delay(DomainSystemConfig.sonarDelay); //avoid fast generation
        }
    }
}
