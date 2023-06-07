package planettrade.Classes;

public class Cargo {

    Commodity commodity;
    int quantityOfCommodity;
    final int maxQuantity;

    public Cargo(Commodity commodity, int quantityOfCommodity, int maxQuantity) {
        this.commodity = commodity;
        this.quantityOfCommodity = quantityOfCommodity;
        this.maxQuantity = maxQuantity;
    }
}
