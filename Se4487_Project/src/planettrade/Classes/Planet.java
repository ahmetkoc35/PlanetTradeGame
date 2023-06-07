package planettrade.Classes;


import project.gameengine.base.GameContext;


public class Planet implements GameContext {

    private final String name;
    private Market market;
    private final int unitFuelPrice;
    private final int parkingPrice;
    private final int distance;

    public Planet(String name, Market market, int unitFuelPrice, int parkingPrice, int distance) {
        this.name = name;
        this.market = market;
        this.unitFuelPrice = unitFuelPrice;
        this.parkingPrice = parkingPrice;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getUnitFuelPrice() {
        return unitFuelPrice;
    }

    public int getParkingPrice() {
        return parkingPrice;
    }

    public int getDistance() {
        return distance;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public String toString()
    {
        return "Name:" + this.name + " FuelPrice:" + this.unitFuelPrice + " ParkingPrice:" + this.parkingPrice +
                " \n---PlanetMarket---" + market.toString();
    }
}
