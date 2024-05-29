package EXAMEN2_PERE;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Employee implements Serializable{
    private int employeeId;
    private String firstName;
    private String lastName;
    private String eMail;
    private String jobId;
    private String jobTitle;

    public Employee(int employeeId, String firstName, String lastName, String eMail, String jobId, String jobTitle) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail + ", jobId=" + jobId + ", jobTitle=" + jobTitle + '}';
    }


    
}
