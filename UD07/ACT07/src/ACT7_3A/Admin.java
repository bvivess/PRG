package ACT7_3A;

public class Admin extends Employee {

    public Admin(int empId, String name, String ssn, double salary) {
        super(empId, name, ssn, salary);
    }
 
    public String printAdmin() {
        return "Admin {" + super.printEmployee() + "}";
    }

}
