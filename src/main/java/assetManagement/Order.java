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
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
