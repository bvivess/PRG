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
        //this.empId = empId;
        // this.name = name;
        // this.ssn = ssn;
        // this.salary = salary;

        this.setEmpId(empId);
        this.setName(name);
        this.setSsn(ssn);
        this.setSalary(salary);
    }
    
    public void raiseSalary(double increase) {
        if (increase > 0)
            // this.salary += increase;
            setSalary(this.salary + increase);
    }

    public String printEmployee() {
        return "Employee{" + "empId=" + this.getEmpId() + ", name=" + this.getName() + ", ssn=" + this.getSsn() + ", salary=" + this.getSalary() + '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!(name.equals("") | name == null))
            this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

    
}

