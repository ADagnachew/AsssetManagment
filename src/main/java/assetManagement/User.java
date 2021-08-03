package assetManagement;

import java.util.List;

public class User extends Role{

    private List<Order> orders;

    public User(Person p,List<Order> orders) {
        super(p);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "orders=" + orders +
                '}';
    }
}
