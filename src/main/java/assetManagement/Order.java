package assetManagement;

import java.time.LocalDateTime;

public class Order {

    private String orderId;
    private float amount;
    private LocalDateTime orderDate;
    private LocalDateTime returnDate;

    private Manager manager;
    private StockKeeper stockKeeper;
    private User user;
    private OrderStatus orderStatus;

    public Order(String orderId, float amount, LocalDateTime orderDate, LocalDateTime returnDate) {
        this.orderId = orderId;
        this.amount = amount;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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
}
