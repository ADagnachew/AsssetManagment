package assetManagement;

import java.util.List;

public class Manager extends Role{

    private List<Order> orders;

    public Manager(Person p,List<Order> orders) {
        super(p);
        this.orders = orders;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
