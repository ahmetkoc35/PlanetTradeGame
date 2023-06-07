package planettrade.Actions;

import planettrade.Choose;
import planettrade.Classes.Cargo;
import planettrade.Classes.Commodity;
import planettrade.Classes.Gamers;
import project.gameengine.base.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SellCargo implements Action {

    Gamers gamers;

    public SellCargo(Gamers gamers) {
        this.gamers = gamers;
        List<Commodity> commodities = new ArrayList<>();
        long price = 0;
        System.out.println("Which Cargo Would You Want To Sell");
        display();
        int chose = Choose.choseCommodity();
        for (int market = 0; market < gamers.getSpaceship().getCargoList().size(); market++)
        {
            Commodity selectedCommodity = gamers.getSpaceship().getCargoList().get(chose);

            price += (long) gamers.getCurrentPlanet().getMarket().getUnitSellPrice() *
                    selectedCommodity.getUnitVolume() *
                    (1 - (selectedCommodity.getDecayRatio()));
            commodities.add(selectedCommodity);
            gamers.setCurrentMoney((int) (gamers.getCurrentMoney() + (price)));
        }
        commodities.forEach(c -> gamers.getSpaceship().dropCargo(c));
    }

    private void display()
    {
        List<Commodity> commodities = gamers.getSpaceship().getCargoList();
        IntStream.range(0,commodities.size())
                .forEach(i -> System.out.println(i + " - " + commodities.get(i) + "\n"));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Item Sold..\n").append(gamers.getName()).append("'s CurrentMoney:").append(gamers.getCurrentMoney());
        return s.toString();
    }
}
