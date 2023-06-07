package planettrade;

import planettrade.Classes.Commodity;
import planettrade.Classes.Gamers;
import planettrade.Classes.Market;
import project.gameengine.base.Action;
import project.gameengine.base.Game;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

import java.util.List;

public class PlanetTradeGame implements Game {

    int turnCount;
    private PTGameContext ptGameContext;
    private boolean isOver = false;
    private List<Player> players;

    public PlanetTradeGame(int turnCount) {
        this.turnCount = turnCount;
    }

    @Override
    public boolean isOver() {
        return getIsOver();
    }

    @Override
    public void init(List<Player> players) {

        this.players = players;

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }
        System.out.println("\n");

        ptGameContext = new PTGameContext(players);

        players.forEach(p -> p.prepareForGame(ptGameContext));

    }

    @Override
    public GameContext getContext() {
        return ptGameContext;
    }

    @Override
    public void update(Action action) {
        System.out.println("\n-------------Display------------");
        players.forEach(System.out::println);
        System.out.println("--------------------------------\n");
    }

    @Override
    public int minimumPlayerCount() {
        return 1;
    }

    @Override
    public int maximumPlayerCount() {
        return 5;
    }

    public boolean getIsOver()
    {
        return isOver;
    }

    @Override
    public String toString() {
        return "PlanetTradeGame{}\n";
    }
}
