package assetManagement;

public class Person {

    private String id;
    private String firstName;
    private String LastName;

    private Department department;

    public Person() {
    }

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
