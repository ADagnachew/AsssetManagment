package assetManagement;

import java.util.List;

public class Person {

    private String id;
    private String firstName;
    private String LastName;

    private Department department;
    private List<Role> roles;

    public Person() {
    }

    public Person(String id, String firstName, String lastName,Department dep, List<Role> asList) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        roles=asList;
        department=dep;
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

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
