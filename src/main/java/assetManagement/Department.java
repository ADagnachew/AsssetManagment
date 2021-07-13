package assetManagement;

import java.util.List;

public class Department {

    private String depId;
    private String name;

    private List<Person> people;

    public Department(String depId, String name) {
        this.depId = depId;
        this.name = name;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
