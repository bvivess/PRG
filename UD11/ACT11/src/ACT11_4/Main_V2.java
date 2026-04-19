package ACT11_4;

import ACT11_4.Classes.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main_V2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Set<Employee> employees = new HashSet<Employee>();
        Set<Location> locations = new HashSet<Location>();
        Set<Department> departments = new HashSet<Department>();
        // Establir la connexió
        try ( Connection connexio = getConnectionFromFile("c:\\temp\\mysql.con")  ) {
            System.out.println("Connexió establerta.");
 
            connexio.setAutoCommit(false);
            llegeixArxiuABBDD(connexio, "c:\\temp\\ACT11_4.csv", employees, locations, departments);
            
            // Mostra les estructures
            System.out.println(employees);
            System.out.println(locations);
            System.out.println(departments);
        } catch (Exception e) {
            System.err.println("S'ha produït l'error general: " + e.getMessage());
        }
    }
    
    private static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
        Map<String, String> valorsConnexio = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                try {
                    if (!linia.substring(0, 1).equals("#")) {
                        String[] parts = linia.split("=");
                        String clau = parts[0].trim();
                        String valor = (parts[1] == null ? "" : parts[1].trim());  // cas de 'PASSWD = '
                    
                        switch (clau) {
                            case "SERVER", "DBASE", "USER", "PASSWD" -> valorsConnexio.put(clau, valor);
                            default -> throw new SQLException("Entrada no vàlida en arxiu de connexió: " + clau);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Cas que l'split no fncioni
                    // No fer res
                }
            }
            if (!valorsConnexio.containsKey("SERVER") ||
                !valorsConnexio.containsKey("DBASE") ||
                !valorsConnexio.containsKey("USER") ||
                !valorsConnexio.containsKey("PASSWD"))
                    throw new SQLException("L'arxiu no contempla totes les dades de connexió");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection( valorsConnexio.get("SERVER") + valorsConnexio.get("DBASE"), 
                                            valorsConnexio.get("USER"), 
                                            valorsConnexio.get("PASSWD"));
    }
    
    private void llegeixArxiuABBDD(Connection connexio, String filename,
                                          Set<Employee> employees,
                                          Set<Location> locations,
                                          Set<Department> departments) throws SQLException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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
                    ResultSet rs = (ResultSet) executaSQL(connexio, 
                                                          "SELECT '1' FROM departments WHERE department_id=?",
                                                          department.getManagerId());
                    if (!rs.next())
                        if ((Integer) executaSQL(connexio, 
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
                    rs = (ResultSet) executaSQL(connexio, 
                                                "SELECT '1' FROM locations WHERE location_id=?",
                                                department.getLocationId());
                    if (!rs.next())
                        if ((Integer) executaSQL(connexio, 
                                                 """
                                                    INSERT INTO locations (LOCATION_ID, CITY)
                                                    VALUES (?,?)
                                                 """,
                                                 location.getLocationId(),
                                                 location.getCity()) > 0)
                                        
                        locations.add(location);
                    
                    // Insertar la fila a 'departments'
                    if ((Integer) executaSQL(connexio,
                                             """
                                                INSERT INTO departments(department_id, department_name, manager_id, location_id)
                                                VALUES (?, ?, ?, ?),
                                             """,
                                             department.getDepartmentId(),
                                             department.getDepartmentName(),
                                             department.getManagerId(),
                                             department.getLocationId()) > 0) {
                        System.out.println("Insertant departament: " + parts[0]);
                        departments.add(department);
                    }
                    connexio.commit();
                } catch (SQLException e) {
                    connexio.rollback();
                    System.err.println("Error executant la instrucció SQL: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e; // Es propaga l'excepció al mètode següent
        }
    }
    
    // Executa SELECT, INSERT, DELETE, UPDATE
    public Object executaSQL(Connection conn, String sql, Object... arguments) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            assignaArguments(stmt, arguments);
            
            if (sql.contains("SELECT"))
                return stmt.executeQuery();
            else // INSERT, DELETE, UPDATE
                return stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private void assignaArguments(PreparedStatement stmt, Object... arguments) throws SQLException {
        for (int i = 0; i < arguments.length; i++) {
            Object arg = arguments[i];

            if (arg == null) {
                stmt.setObject(i + 1, null);
            } else if (arg instanceof Integer) {
                stmt.setInt(i + 1, (Integer) arg);
            } else if (arg instanceof Long) {
                stmt.setLong(i + 1, (Long) arg);
            } else if (arg instanceof Double) {
                stmt.setDouble(i + 1, (Double) arg);
            } else if (arg instanceof Float) {
                stmt.setFloat(i + 1, (Float) arg);
            } else if (arg instanceof Boolean) {
                stmt.setBoolean(i + 1, (Boolean) arg);
            } else if (arg instanceof LocalDate) {
                stmt.setDate(i + 1, Date.valueOf((LocalDate) arg));
            } else if (arg instanceof java.sql.Date) {
                stmt.setDate(i + 1, (java.sql.Date) arg);
            } else if (arg instanceof Timestamp) {
                stmt.setTimestamp(i + 1, (Timestamp) arg);
            } else {
                stmt.setObject(i + 1, arg);
            }
        }
    }
    
}