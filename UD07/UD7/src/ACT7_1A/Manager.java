package ACT7_1A;

class Manager extends Employee {
    private String deptName;

    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
    
    public String printManager() {
        return "Manager {" + super.printEmployee() + ", deptName=" + this.deptName + "}";
    }
    
}

