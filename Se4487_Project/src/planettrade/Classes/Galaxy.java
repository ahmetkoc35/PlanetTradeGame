package planettrade.Classes;

import planettrade.Factories;

import java.util.List;

public class Galaxy {
    private List<Planet> planetList;
    private final String name;

    public Galaxy() {
        this.name = "Galaxy -1-";
        this.planetList = Factories.planetFactory();
    }


    public List<Planet> getPlanets() {
        return planetList;
    }
}
