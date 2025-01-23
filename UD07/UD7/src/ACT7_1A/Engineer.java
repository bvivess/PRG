package ACT7_1A;

public class Engineer extends Employee {

    public Engineer(int empId, String name, String ssn, double salary) {
        super(empId, name, ssn, salary);
    }

    public String printEngineer() {
        return "Engineer {" + super.printEmployee() + "}";
    }
       
}
