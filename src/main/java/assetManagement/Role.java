package assetManagement;

public abstract class Role {

    private Person person;

    public Role(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Role{" +
                "person=" + person +
                '}';
    }
}
