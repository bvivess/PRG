package ACT7_1A;

import java.util.ArrayList;

class Manager extends Employee {
    private String deptName;
    private ArrayList<Employee> staff;

    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        
        super(empId, name, ssn, salary);
        this.deptName = deptName;
        this.staff = new ArrayList<>();
    }
    
    public boolean addEmployee(Employee e) {
        if (this.staff.contains(e))
            return false;
        else {
            this.staff.add(e);
            return true;
        }
    }
    
    public boolean removeEmployee(Employee e) {
        return this.staff.remove(e);
    }

    public String getDeptName() {
        return deptName;
    }
    
    public String printManager() {
        String text = "Manager {" + super.printEmployee() + ", deptName=" + this.deptName;
        for (Employee e : this.staff)
            text = text + e.printEmployee();
        return text + "}";
    }
    
}

