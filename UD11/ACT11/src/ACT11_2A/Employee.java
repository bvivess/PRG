package ACT11_2A;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private double salary;
    private LocalDate hireDate;

    public Employee(int id, String last_name, String first_name, String email, double salary, LocalDate hireDate) throws IllegalArgumentException {
        setId(id);
        setLastName(last_name);
        setFirstName(first_name);
        setEmail(email);
        setSalary(salary);
        setHireDate(hireDate);
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

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException (lastName + " Last name incorrecte");
        else
            this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException (firstName + " First name incorrecte");
        else
            this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.isBlank() || !email.matches("^[\\w.]+@[\\w.-]+\\.[a-zA-Z]{2,6}$"))  // en comptes de: email.contains("@")
            throw new IllegalArgumentException (email + " Email incorrecte");
        else
            this.email = email;       
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary<0)
            throw new IllegalArgumentException (salary + " Salary incorrecte");
        else
            this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", salary=" + salary + ", hireDate=" + hireDate + '}';
    }
    
}
