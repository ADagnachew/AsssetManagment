package assetManagement;

import java.util.List;

public class Manager extends Role{

    private List<Order> orders;
    public Manager(List<Order> orders) {
    super();
        this.orders=orders;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
