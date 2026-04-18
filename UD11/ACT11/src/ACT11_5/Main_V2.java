package ACT11_5;

import ACT11_5.Classes.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
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
            llegeixArxiuABBDD(connexio, "c:\\temp\\ACT11_5.csv", employees, locations, departments);
            
            // Mostra les estructures
            System.out.println(employees);
            System.out.println(locations);
            System.out.println(departments);
        } catch (Exception e) {
            System.err.println("S'ha produït l'error general: " + e.getMessage());
        }
    }
    
    private static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
        Map<ValorsConnexio, String> valorsConnexio = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                try {
                    if (!linia.substring(0, 1).equals("#")) {
                        String[] parts = linia.split("=");
                        String clau = parts[0].trim();
                        String valor = (parts[1]==null ? "" : parts[1].trim());  // cas de 'PASSWD = '
                    
                        switch (clau) {
                            case "SERVER" -> valorsConnexio.put( ValorsConnexio.SERVER, valor);
                            case "DBASE" -> valorsConnexio.put( ValorsConnexio.DBASE, valor);
                            case "USER" -> valorsConnexio.put( ValorsConnexio.USER, valor);
                            case "PASSWD" -> valorsConnexio.put( ValorsConnexio.PASSWD, valor);
                            default -> System.err.println("Clau no vàlida: " + clau);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Cas que l'split no fncioni
                    // No fer res
                }
            }
            if (!valorsConnexio.containsKey(ValorsConnexio.SERVER) ||
                !valorsConnexio.containsKey(ValorsConnexio.DBASE) ||
                !valorsConnexio.containsKey(ValorsConnexio.USER) ||
                !valorsConnexio.containsKey(ValorsConnexio.PASSWD))
                    throw new SQLException("L'arxiu no contempla totes les dades de connexió");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection( valorsConnexio.get(ValorsConnexio.SERVER) + valorsConnexio.get(ValorsConnexio.DBASE), 
                                            valorsConnexio.get(ValorsConnexio.USER), 
                                            valorsConnexio.get(ValorsConnexio.PASSWD));
    }
    
    private static void llegeixArxiuABBDD(Connection connexio, String filename,
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
                    if (!SQLCheckPK(connexio, "employees", department.getManagerId())) {
                        SQLInsert(connexio, "employees", employee);
                        employees.add(employee);
                    }
                    
                    // Comprovar integritat referencial amb 'locations'
                    if (!SQLCheckPK(connexio, "locations", department.getLocationId())) {
                        SQLInsert(connexio, "locations", location);
                        locations.add(location);
                    }
                    
                    // Insertar la fila a 'departments'
                    SQLInsert(connexio, "departments", department);
                    System.out.println("Insertant departament: " + parts[0]);
                    departments.add(department);

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
    
    private static void SQLInsert(Connection connexio, String table, Object o) throws SQLException  {
        String sql="";
        PreparedStatement statement;
        
        // Cal millorar aquest mètode accedint al diccionari MySQL:
        //    - information_schema.tables:
        //    SELECT TABLE_NAME 
        //    FROM information_schema.TABLES 
        //    WHERE TABLE_SCHEMA = &&esquema
        //    AND   TABLE_NAME = &&tabla;
        //
        //    - information_schema.columns:
        //    SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_KEY, COLUMN_DEFAULT
        //    FROM information_schema.COLUMNS
        //    WHERE TABLE_SCHEMA = &&esquema
        //    AND   TABLE_NAME = &&tabla;

        try {
            if (table.equals("employees")) {
                sql = """
                      INSERT INTO employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID)
                      VALUES (?, ?, ?, ?)
                      """;
                Employee e = (Employee) o;
                statement = connexio.prepareStatement(sql);
                statement.setInt(1, e.getEmployeeId());
                statement.setString(2, e.getFirstName());
                statement.setString(3, e.getLastName());
                statement.setString(4, e.getJobId());
                statement.executeUpdate();
            } else if (table.equals("locations")) {
                sql = """
                      INSERT INTO locations (LOCATION_ID, CITY)
                      VALUES (?,?)
                      """;
                Location l = (Location) o;
                statement = connexio.prepareStatement(sql);
                statement.setInt(1, l.getLocationId());
                statement.setString(2, l.getCity());
                statement.executeUpdate();
            } else if (table.equals("departments")) {
                sql = """
                      INSERT INTO departments (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
                      VALUES (?, ?, ?, ?)
                      """;
                Department d = (Department) o;
                statement = connexio.prepareStatement(sql);
                statement.setInt(1, d.getDepartmentId());
                statement.setString(2, d.getDepartmentName());
                statement.setInt(3, d.getManagerId());
                statement.setInt(4, d.getLocationId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        } 

    }
    
    private static boolean SQLCheckPK(Connection connexio, String taula, int primaryKey) throws SQLException  {
        String sql="";
        
        // Cal millorar aquest mètode accedint al diccionari MySQL
        try {
            if (taula.equals("employees"))
                sql = "SELECT '1' FROM employees WHERE employee_id = ?";
            else if (taula.equals("locations"))
                sql = "SELECT '1' FROM locations WHERE location_id = ?";
            
            PreparedStatement statement = connexio.prepareStatement(sql);
            statement.setInt(1, primaryKey);

            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next(); // si existeix al manco 1 fila ?
        } catch (SQLException e) {
            throw new SQLException (e.getMessage() );
        } 
    }
}