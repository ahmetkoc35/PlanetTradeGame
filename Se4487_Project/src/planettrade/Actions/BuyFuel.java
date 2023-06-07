package planettrade.Actions;

import planettrade.Classes.Gamers;
import project.gameengine.base.Action;

public class BuyFuel implements Action {

    Gamers gamers;
    long fuelToBuyPrice;
    long fuelToBuy;
    public BuyFuel(Gamers gamers) {
        this.gamers = gamers;
        fuelToBuy = gamers.getSpaceship().getFuelCapacity() - gamers.getSpaceship().getCurrentFuel();
        fuelToBuyPrice = fuelToBuy * gamers.getCurrentPlanet().getUnitFuelPrice();

        if (gamers.getCurrentMoney() <= fuelToBuyPrice)
        {
            System.out.println("You Don't Have Enough Money");
        }
        else {
            gamers.setCurrentMoney((int) (gamers.getCurrentMoney() -
                    (gamers.getCurrentPlanet().getUnitFuelPrice() * fuelToBuy)));
            gamers.getSpaceship().setCurrentFuel(gamers.getSpaceship().getFuelCapacity());
        }

    }

    @Override
    public String toString() {
        return gamers.getName() + " bought " + fuelToBuy + " Liters Of Fuel!";
    }
}
