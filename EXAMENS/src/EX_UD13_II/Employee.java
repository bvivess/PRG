package EX_UD13_II;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String eMail;
    private String jobId;

    public Employee(int employeeId, String firstName, String lastName, String eMail, String jobId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.jobId = jobId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail + ", jobId=" + jobId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.employeeId;
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
        return this.employeeId == other.employeeId;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();  // assegura el procés normal de serialitzacio

        // Afegeix un 'timestamp' en la serialització
        oos.writeObject(new java.util.Date());  // escriu un timestamp
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();  // assegura el procés normal de deserialització

        // Mostra el 'timestamp' fet en la serialització
        System.out.println ("Emmagatzemat en data: " + (java.util.Date) ois.readObject()); // mostra el 'timestamp'
    }

}
