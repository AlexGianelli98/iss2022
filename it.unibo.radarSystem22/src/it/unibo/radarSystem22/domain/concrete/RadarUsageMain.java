package it.unibo.radarSystem22.domain.concrete;
import radarPojo.radarSupport;

public class RadarUsageMain {
    public void doJob() {
        System.out.println("start");
        radarSupport.setUpRadarGui();
        radarSupport.update( "55", "23");
    }
    public static void main(String[] args) {
        new RadarUsageMain().doJob();
    }
}