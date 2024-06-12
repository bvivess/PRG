package EX_RECUPERACIO_13A;

public abstract class Persona {
    private int customerId;
    private String FirstName;
    private String LastName;

    public Persona(int customerId, String FirstName, String LastName) {
        this.customerId = customerId;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
    
}
