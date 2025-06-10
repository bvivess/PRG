package EXAMEN.model;

import java.util.Objects;

public class Employee implements Comparable <Employee> {
    private String email;
    private String firstName;
    private String lastName;
    private Department department;

    public Employee(String email, String fisrtName, String lastName, Department department) {
        this.email = email;
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.department = department;
    }
    
    @Override
    public int compareTo(Employee o) {
        return (this.getLastName()+this.getFirstName()).compareTo((o.getLastName()+o.getFirstName()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.email, other.email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fisrtName) {
        this.firstName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "completeName=" + lastName + " " + firstName + ", email=" + email + ", department=" + department + '}';
    }

}
