package ACT7_1C;

/**
 *
 * @author Administrador
 */
public class Employee {
    private int empId;
    private String name;
    private String jobTitle;
    private String level;
    //
    private static int employeeIdCounter=0;

    public Employee(String name, String jobTitle, String level) {
        this.empId = this.calculateEmployeeId();
        this.name = name;
        this.jobTitle = jobTitle;
        this.level = level;
    }
    
    public int calculateEmployeeId() {
        return Employee.employeeIdCounter++;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", name=" + name + ", jobTitle=" + jobTitle + ", level=" + level + '}';
    }
}

