package com.example;

/**
 *
 * @author Oracle
 * 
 * Exemple de Herència Multinivell:
 *    Employee(empId, name, ssn, salary)
 *        ^       ^      ^
 *        |       |      |
 *     Manager    Admin  Engineer
 *     (deptName) ()     ()
 *        ^ 
 *        |
 *      Director
 * 
 */

import com.example.domain.Employee;
import com.example.domain.Engineer;
import com.example.domain.Manager;
import com.example.domain.Admin;
import com.example.domain.Director;
import java.text.NumberFormat;

public class EmployeeTest {

    public static void main(String[] args) {

        // Create the classes as per the practice
        Engineer eng = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);
        
        Manager mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");

        Admin adm = new Admin(304, "Bill Munroe", "108-23-6509", 75_002.34);

        Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);
        
        // Prova Polimorfisme 'casting entre subclasses'
        Employee e0 = new Employee(997, "Susan Wheeler", "099-45-2340", 120_567.36);
        Director d = new Director(998, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);
        Manager m = new Manager(999, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
        
        Employee e1 = new Manager(999, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
        Manager m1 = (Manager) e1;
        
        if (m1 instanceof Manager)
            System.out.println("m1 es manager con dpt " + m1.getDeptName());
        
        if (e1 instanceof Employee)
            System.out.println("e1 és Employee" + e1.getEmpId());

        // Prova2
        Employee e2 = new Manager(9999, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
        if (e2 instanceof Employee)
            System.out.println("e2 és Employee" + e2.getEmpId()  );

        // Print information about the objects you created
        printEmployee(eng);
        printEmployee(adm);
        printEmployee(mgr);
        printEmployee(dir);

        System.out.println("\nTesting raiseSalary and setName on Manager:");
        mgr.setName ("Barbara Johnson-Smythe");
        mgr.raiseSalary(10_000.00);
        printEmployee(mgr);
       
    }

    public static void printEmployee(Employee emp) {
        System.out.println(); // Print a blank line as a separator
        // Print out the data in this Employee object
        System.out.println("Employee id:         " + emp.getEmpId());
        System.out.println("Employee name:       " + emp.getName());
        System.out.println("Employee Soc Sec #:  " + emp.getSsn());
        System.out.println("Employee salary:     " + NumberFormat.getCurrencyInstance().format((double) emp.getSalary()));
    }
}