package planettrade.Classes;

import project.gameengine.base.GameContext;

public class Commodity implements GameContext {

    String name;
    int unitVolume;
    double decayRatio;

    public Commodity(String name, int unitVolume, double decayRatio) {
        this.name = name;
        this.unitVolume = unitVolume;
        this.decayRatio = decayRatio;
    }

    public int getUnitVolume() {
        return unitVolume;
    }

    public double getDecayRatio() {
        return decayRatio;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", unitVolume=" + unitVolume +
                ", decayRatio=" + decayRatio +
                '}';
    }
}
