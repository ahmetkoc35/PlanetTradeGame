package planettrade;

import planettrade.Classes.BlackHole;
import planettrade.Classes.Galaxy;
import planettrade.Classes.Planet;
import planettrade.Classes.Spaceship;
import project.gameengine.base.Game;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

import java.util.ArrayList;
import java.util.List;

public class PTGameContext implements GameContext
{
    BlackHole blackHole;
    Galaxy galaxy;
    private static PTGameContext instance = null;
    private List<Player> players;
    private List<Planet> planets;
    public List<Player> getPlayers() {
        return players;
    }

    public PTGameContext(List<Player> players){

        this.players = players;
        planets = new ArrayList<>();
        init();

    }

    private void init()
    {
        blackHole = new BlackHole();
        galaxy = blackHole.explode();
        planets = galaxy.getPlanets();
        System.out.println("\n");
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }
}
