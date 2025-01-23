package ACT7_1A;

/**
 *
 * @author Administrador
 */
public class Employee {
    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }
    
    public void raiseSalary(double increase) {
        
    }

    public String printEmployee() {
        return "Employee{" + "empId=" + empId + ", name=" + name + ", ssn=" + ssn + ", salary=" + salary + '}';
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}

