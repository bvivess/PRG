package ex_final.Classes;

import java.time.LocalDate;


public class Employee extends Person {
    private LocalDate hireDate;
    private double salary;
    private double commissionPct;
    private Department department;

    public Employee( int id, String firstName, String lastName, String email, String phoneNumber, 
                     LocalDate hireDate, double salary, double commissionPct, Department department ) {
        super(id, firstName, lastName, email, phoneNumber);
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.department = department;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + " Employee{" + "hireDate=" + hireDate + ", salary=" + salary + ", commissionPct=" + commissionPct + ", department=" + department + '}';
    }
    
}
