package assetManagement;

import java.util.List;

public class University {

    private String id;
    private String uniName;
    private List<Department> departments;
    private List<Stock> stocks;

    public University(String id, String uniName) {
        this.id = id;
        this.uniName = uniName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        uniName = uniName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
