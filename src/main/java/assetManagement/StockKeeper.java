package assetManagement;

import java.util.List;

public class StockKeeper extends Role{

    private List<StockKeeper> stockKeepers;

    public List<StockKeeper> getStockKeepers() {
        return stockKeepers;
    }

    public void setStockKeepers(List<StockKeeper> stockKeepers) {
        this.stockKeepers = stockKeepers;
    }
}
