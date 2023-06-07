package planettrade.Classes;

import project.gameengine.base.GameContext;

import java.util.List;

public class Spaceship implements GameContext {

    private final String name;
    private final long buyPrice;
    private List<Commodity> cargoList;
    private final int volumeOfCapacity;
    private final int speed;
    private long currentFuel;
    private final long fuelCapacity;
    private final long fuelUsagePerDistance;



    public Spaceship(String name, long buyPrice, List<Commodity> cargoList, int volumeOfCapacity,
                     int speed, long currentFuel, long fuelCapacity, long fuelUsagePerDistance) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.cargoList = cargoList;
        this.volumeOfCapacity = volumeOfCapacity;
        this.speed = speed;
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.fuelUsagePerDistance = fuelUsagePerDistance;
    }

    public String getName() {
        return name;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public void setCurrentFuel(long currentFuel) {
        this.currentFuel = currentFuel;
    }

    public List<Commodity> getCargoList() {
        return cargoList;
    }

    public void addCargo(Commodity commodity)
    {
        getCargoList().add(commodity);
    }

    public void dropCargo(Commodity commodity)
    {
        getCargoList().remove(commodity);
    }

    public long getCurrentFuel() {
        return currentFuel;
    }

    public long getFuelCapacity() {
        return fuelCapacity;
    }

    public long getFuelUsagePerDistance() {
        return fuelUsagePerDistance;
    }

    public String toString()
    {

        return "Name:" + this.name + " BuyPrice:" + this.buyPrice + " CargoList:" + this.cargoList
                + " \nVolumeOfCapacity:" + this.volumeOfCapacity + " Speed:" + this.speed + " CurrentFuel:"
                + this.currentFuel + " FuelCapacity:" + this.fuelCapacity + " FuelUsage:" + this.fuelUsagePerDistance;
    }
}
