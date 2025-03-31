package ACT11_2;

/**
 *
 * @author Administrador
 */
public class Persona {
    private int id;
    private String lastName;
    private String firstName;
    private String email;

    public Persona(int id, String last_name, String first_name, String email) {
        setId(id);
        setLastName(last_name);
        setFirstName(first_name);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@"))
            this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", last_name=" + lastName + ", first_name=" + firstName + ", email=" + email + '}';
    }
    
}
