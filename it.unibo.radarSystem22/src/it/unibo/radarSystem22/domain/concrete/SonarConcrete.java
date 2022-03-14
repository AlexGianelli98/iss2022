package it.unibo.radarSystem22.domain.concrete;

import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.models.SonarModel;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SonarConcrete extends SonarModel implements ISonar{
    private Process p;
    private BufferedReader reader;

    @Override
    protected void sonarSetUp() {
        curVal = new Distance(90);
    }

    @Override
    public void activate() {
        if (p == null) {
            try {
                p = Runtime.getRuntime().exec("sudo ./SonarAlone");
                reader = new BufferedReader( new InputStreamReader(p.getInputStream()) );
            } catch(Exception e) { e.printStackTrace(); }
        }
        super.activate();
    }

    protected void sonarProduce() {
        try {
            String data = reader.readLine();
            if( data == null ) return;
            int v = Integer.parseInt(data);
            int lastSonarVal = curVal.getVal();
            // Eliminiamo dati fuori "credibility bound"
            if(lastSonarVal != v && v < DomainSystemConfig.sonarDistanceMax) {
                updateDistance(v);
            }
        } catch(Exception e) { e.printStackTrace(); }
    }

    @Override
    public void deactivate() {
        curVal = new Distance(90);
        if(p != null) {
            p.destroy();
            p = null;
        }
        super.deactivate();
    }
}