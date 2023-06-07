package planettrade.Classes;

import planettrade.Actions.BuyCommodity;
import planettrade.Actions.BuyFuel;
import planettrade.Actions.MoveToAnotherPlanet;
import planettrade.Actions.SellCargo;
import planettrade.Choose;
import planettrade.PTGameContext;
import project.gameengine.NullAction;
import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

public class Gamers implements Player {

    private long currentMoney;
    private final String name;
    Spaceship spaceship;
    Planet currentPlanet;

    public Gamers(String name, long currentMoney, Spaceship spaceship, Planet currentPlanet) {
        this.currentMoney = currentMoney;
        this.name = name;
        this.spaceship = spaceship;
        this.currentPlanet = currentPlanet;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public long getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public String toString()
    {
        return "Name:" + getName() + " CurrentMoney:" + getCurrentMoney()
                + " SpaceShip:" + spaceship.getName() + " CurrentPlanet:"
                + currentPlanet.getName() + " Current Fuel:" + spaceship.getCurrentFuel();
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    public String getName() {
        return name;
    }

    @Override
    public Action play(GameContext context) {
        System.out.println(this.getName() + " What Would You Want To Do\n" + "1 For To BuyCommodity \n2 For To SellCargo\n" +
                "3 For Tu Buy Fuel \n4 For To Travel To Another Planet");
        int choose = Choose.choseAction();
        return switch (choose)
        {
            case 1 -> new BuyCommodity(this);
            case 2 -> new SellCargo(this);
            case 3 -> new BuyFuel(this);
            case 4 -> new MoveToAnotherPlanet(this,((PTGameContext)context).getGalaxy().getPlanets());
            default -> new NullAction();
        };
    }

    @Override
    public void prepareForGame(GameContext context) {

    }



}
