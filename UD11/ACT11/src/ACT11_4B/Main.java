package ACT11_4B;

import ACT11_4B.Classes.*;
import ACT11_4B.Utils.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        
        Set<Employee> employees = new HashSet<Employee>();
        Set<Location> locations = new HashSet<Location>();
        Set<Department> departments = new HashSet<Department>();
        // Establir la connexió
        try {
            arxiuABBDD(gestorBBDD, "c:\\temp\\ACT11_4.csv", employees, locations, departments);
            
            // Mostra les estructures
            System.out.println(employees);
            System.out.println(locations);
            System.out.println(departments);
        } catch (Exception e) {
            System.err.println("S'ha produït l'error general: " + e.getMessage());
        }
    }
    
    private static void arxiuABBDD(GestorBBDD gestorBBDD, String filename,
                                          Set<Employee> employees,
                                          Set<Location> locations,
                                          Set<Department> departments) throws SQLException, IOException {
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            conn.setAutoCommit(false);
            
            String line = reader.readLine(); // Es descarta la primera línia
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int departmentId = Integer.parseInt(parts[0]);
                String departmentName = parts[1];
                int managerId = Integer.parseInt(parts[2]);
                int locationId = Integer.parseInt(parts[3]);
                // Objectes
                Employee employee = new Employee(managerId, "S/D", "S/D", "IT_PROG");  // "S/D"-> "Sense Descripció"
                Location location = new Location(locationId, "S/D");
                Department department = new Department(departmentId, departmentName, managerId, locationId);
                
                try {
                    // Comprovar integritat referencial amb 'employees'
                    ResultSet rs = (ResultSet) gestorBBDD.executaSQL(conn, 
                                                          "SELECT '1' FROM employees WHERE employee_id = ?",
                                                          department.getManagerId());
                    if (!rs.next())
                        if ((Integer) gestorBBDD.executaSQL(conn, 
                                                 """
                                                    INSERT INTO employees(employee_id, first_name, last_name, job_id)
                                                    VALUES(?,?,?,?)
                                                 """,
                                                 employee.getEmployeeId(),
                                                 employee.getFirstName(),
                                                 employee.getLastName(),
                                                 employee.getJobId()) > 0)
                            employees.add(employee);
                    
                    // Comprovar integritat referencial amb 'locations'
                    rs = (ResultSet) gestorBBDD.executaSQL(conn, 
                                                "SELECT '1' FROM locations WHERE location_id = ?",
                                                department.getLocationId());
                    if (!rs.next())
                        if ((Integer) gestorBBDD.executaSQL(conn, 
                                                 """
                                                    INSERT INTO locations (LOCATION_ID, CITY)
                                                    VALUES (?, ?)
                                                 """,
                                                 location.getLocationId(),
                                                 location.getCity()) > 0)
                            locations.add(location);
                    
                    // Insertar la fila a 'departments'
                    if ((Integer) gestorBBDD.executaSQL(conn,
                                             """
                                                INSERT INTO departments(department_id, department_name, manager_id, location_id)
                                                VALUES (?, ?, ?, ?)
                                             """,
                                             department.getDepartmentId(),
                                             department.getDepartmentName(),
                                             department.getManagerId(),
                                             department.getLocationId()) > 0) {
                        System.out.println("Insertant departament: " + parts[0]);
                        departments.add(department);
                    }

                    conn.commit();
                } catch (SQLException e) {
                    conn.rollback();
                    System.err.println("Error executant la instrucció SQL: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e; // Es propaga l'excepció al mètode següent
        }
    }
    
}