package assetManagement;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String orderId;
    private LocalDateTime orderDate;
    private LocalDateTime returnDate;
    private List<OrderLine> orderLines;
    private Manager manager;
    private StockKeeper stockKeeper;
    private User user;
    private OrderStatus orderStatus;

    public Order(String orderId, LocalDateTime orderDate, LocalDateTime returnDate, List<OrderLine> ordersLines, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.orderLines=ordersLines;
        this.orderStatus =  orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }



    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public StockKeeper getStockKeeper() {
        return stockKeeper;
    }

    public void setStockKeeper(StockKeeper stockKeeper) {
        this.stockKeeper = stockKeeper;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }



    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", returnDate=" + returnDate +
                ", orderLines=" + orderLines +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
