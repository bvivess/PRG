package ACT11_2B;

import ACT11_2A.*;

/**
 *
 * @author Administrador
 */
public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private int departmentId;

    public Employee(int id, String last_name, String first_name, String email, int department_id) throws Exception {
        setId(id);
        setLastName(last_name);
        setFirstName(first_name);
        setEmail(email);
        setDepartmentId(department_id);
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

    public void setLastName(String lastName) throws Exception {
        if (lastName == null)
            throw new Exception ("Last name incorrecte");
        else
            this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if (firstName == null)
            throw new Exception ("First name incorrecte");
        else
            this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        //if (email.contains("@"))
        //    this.email = email;
        if (email == null || !email.contains("@"))
            throw new Exception ("Email incorrecte");
        else
            this.email = email;
                
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", last_name=" + lastName + ", first_name=" + firstName + ", email=" + email + ", departmentId=" + departmentId + '}';
    }
    
}
