package planettrade.Classes;

import project.gameengine.base.GameContext;

import java.util.List;

public class Market implements GameContext {

    int currentSupplyAmount;
    private final int unitBuyPrice;
    private final int unitSellPrice;
    List<Commodity> commodities;


    public Market(int currentSupplyAmount, int unitBuyPrice, int unitSellPrice, List<Commodity> commodities) {
        this.currentSupplyAmount = currentSupplyAmount;
        this.unitBuyPrice = unitBuyPrice;
        this.unitSellPrice = unitSellPrice;
        this.commodities = commodities;
    }

    public int getUnitBuyPrice() {
        return unitBuyPrice;
    }

    public int getUnitSellPrice() {
        return unitSellPrice;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }


    @Override
    public String toString() {
        return "Market{" +
                "unitBuyPrice=" + unitBuyPrice +
                ", unitSellPrice=" + unitSellPrice +
                '}';
    }
}
