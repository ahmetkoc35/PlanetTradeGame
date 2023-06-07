package planettrade.Actions;

import planettrade.Choose;
import planettrade.Classes.Commodity;
import planettrade.Classes.Gamers;
import planettrade.Factories;
import project.gameengine.base.Action;

import java.util.List;
import java.util.stream.IntStream;

@FunctionalInterface
interface CommodityPricer
{
    int calculate(int x, int y, int z);
}
public class BuyCommodity implements Action {

    Gamers gamers;

    public BuyCommodity(Gamers gamers) {
        this.gamers = gamers;
        long price = 0;
        System.out.println("Which Commodity Would You Want To Buy");
        display();
        int chose = Choose.choseCommodity();
        CommodityPricer commodityPricer = (int x, int y, int z) -> x*y*z;
        for (int market = 0; market < gamers.getCurrentPlanet().getMarket().getCommodities().size(); market++)
        {
            Commodity selectedCommodity = gamers.getCurrentPlanet().getMarket().getCommodities().get(chose);

            int a = selectedCommodity.getUnitVolume();
            int b = (int) ((100 - (selectedCommodity.getDecayRatio()))/100);
            int c = gamers.getCurrentPlanet().getMarket().getUnitBuyPrice();
            price += commodityPricer.calculate(a,b,c);

            if (gamers.getCurrentMoney() >= price)
            {
                gamers.getSpaceship().addCargo(selectedCommodity);
                gamers.setCurrentMoney((int) (gamers.getCurrentMoney() - price));
            }
            else
                break;
        }
    }

    private void display()
    {
        List<Commodity> commodities = gamers.getCurrentPlanet().getMarket().getCommodities();
        IntStream.range(0,commodities.size())
                .forEach(i -> System.out.println(i + " - " + commodities.get(i) + "\n"));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Item Bought..");
        return s.toString();
    }
}
