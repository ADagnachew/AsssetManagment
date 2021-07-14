package assetManagement;

import java.util.List;

public class StockKeeper extends Role{

    private List<Order> orders;
    public StockKeeper(List<Order> orders) {

        this.orders=orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
