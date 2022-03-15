package it.unibo.radarSystem22.domain.concrete;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public class Distance implements IDistance {
    private int v;
    public Distance(int d) { v=d; }
    @Override
    public int getVal() { return v; }
    @Override
    public String toString(){ return ""+v; }
}
