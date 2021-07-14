package assetManagement;

import java.util.List;

public class User extends Role{

    private List<Order> orders;

    public User(List<Order> orders) {
        super();
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
