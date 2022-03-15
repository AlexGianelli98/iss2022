package it.unibo.radarSystem22.domain.models;

import it.unibo.radarSystem22.domain.concrete.Distance;
import it.unibo.radarSystem22.domain.concrete.SonarConcrete;
import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.mock.SonarMock;
import it.unibo.radarSystem22.domain.utils.ColorsOut;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public abstract class SonarModel implements ISonar {
    protected boolean stopped = false; //se true il sonar si ferma
    protected IDistance curVal = new Distance(90);

    //Factory methods
    public static ISonar create() {
        if(DomainSystemConfig.simulation)  return createSonarMock();
        else  return createSonarConcrete();
    }

    protected SonarModel() { //hidden costructor, to force setup
        sonarSetUp();
    }

    //Abstract methods
    protected abstract void sonarSetUp() ;
    protected abstract void sonarProduce();

    @Override
    public boolean isActive() { return !stopped; }

    @Override
    public void deactivate() { stopped = true; }
    @Override
    public void activate() {
        stopped = false;
        new Thread() {
            public void run() {
                while(!stopped) { sonarProduce(); }
            }
        }.start();
    }

    @Override
    public IDistance getDistance() {
        return curVal;
    }

    protected void updateDistance(int d) {
        curVal = new Distance( d );
        ColorsOut.out("SonarModel | updateDistance "+ d, ColorsOut.BLUE);
    }

    public static ISonar createSonarMock() {return new SonarMock();}
    public static ISonar createSonarConcrete() {return new SonarConcrete();}
}
