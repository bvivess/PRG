package examen.utils;

import EXAMEN.model.*;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GestorExamen {
    private Set<Department> departments = new HashSet<>();
    private Map<String, Employee> employees = new HashMap<>();
    private Map<Department, List<Employee>> departmentsXemployees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public Map<Department, List<Employee>> getDepartmentsXemployees() {
        return departmentsXemployees;
    }
    
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);

    public void carregaDades()  throws SQLException {
        carregaEmployees();
    }
    
    
    public void carregaEmployees() {
        String sql = """
                     SELECT email, first_name, last_name, e.department_id, department_name
                     FROM departments d, employees e
                     WHERE d.department_id = e.department_id
                     """;
        
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) { 
            Department department;
            Employee employee;
            
            while (resultSet.next()) {
                department = cercaDepartment(departments, new Department( resultSet.getInt("department_id"),
                                                                          resultSet.getString("department_name") ));
                
                employee = new Employee( resultSet.getString("email"),
                                         resultSet.getString("first_name"), 
                                         resultSet.getString("last_name"),
                                         department );
                
                afegeixDepartment(departments, department);

                afegeixEmployee(employees, employee);
                
                afegeixDepartmentsXEmployee(departmentsXemployees, department, employee);
                
            }
            
        } catch (SQLException | IOException e) {
            System.err.println("Error carregant dades de la BBDD: " + e.getMessage());
        }
    }
       
    private Department cercaDepartment(Set<Department> departments, Department department) {
        return this.departments.stream().filter(c1 -> c1.equals(department)).findFirst().orElse(department);
    }

    private void afegeixDepartment(Set<Department> departments, Department department) {
        departments.add(department);
    }
    
    private void afegeixEmployee(Map<String, Employee> empleats, Employee employee) {
        empleats.put(employee.getEmail(), employee);
    }
    
    private void afegeixDepartmentsXEmployee(Map<Department, List<Employee>> departmentsXempleats, Department department, Employee employee) {
        departmentsXempleats.computeIfAbsent(department, d -> new ArrayList<>()).add(employee);
    }
    
    public void mostraDepartments(Set<Department> departments ) {
        System.out.println("DEPARTMENTS");
        this.departments.stream().sorted().forEach(System.out::println);
    }   

    public void mostraEmployees(Map<String, Employee> employees) {
        System.out.println("EMPLOYEES");
        this.employees.values().stream().sorted().forEach(System.out::println);
    } 
    
    public void mostraDepartmentsXEmployees(Map<Department, List<Employee>> departmentsXemployees) {
        System.out.println("DEPARTMENTS X EMPLOYEES");
            departmentsXemployees.entrySet().stream()
                                           .sorted(Map.Entry.comparingByKey()) 
                                           .forEach(entry -> {
                                                        Department departament = entry.getKey();
                                                        List<Employee> empleats = entry.getValue();
                                                        System.out.println("Departament: " + departament);
                                                        empleats.stream()
                                                                .sorted() // ordre natural d'Employee
                                                                .forEach(empleat -> System.out.println("  - " + empleat));
                                                    });
    } 
    
    public void desaDepartmentsXEmployeesCSV(String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Department d : this.departmentsXemployees.keySet().stream().sorted().toList() ) {
                String text = d.getDepartmentId() + "," + d.getName() + ",";
                for (Employee e : this.departmentsXemployees.get(d).stream().sorted().toList())
                    text += e.getEmail() + ";";
                br.write(text);
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant DepartmentsXEmpleats CSV: " + e.getMessage());
        }
    }
    
}
