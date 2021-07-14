package assetManagement;

import java.util.List;

public class Stock {

    private String stockId;
    private String stockName;
    private List<Product> products;

    public Stock(String stockId, String stockName) {
        this.stockId = stockId;
        this.stockName = stockName;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
