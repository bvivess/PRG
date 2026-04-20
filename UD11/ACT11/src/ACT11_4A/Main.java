package ACT11_4A;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Establir la connexió
        try ( Connection connexio = getConnectionFromFile("c:\\temp\\mysql.con")  ) {  // Establir connexió
            System.out.println("Connexió establerta.");
            
            connexio.setAutoCommit(false);
            arxiuABBDD(connexio, "c:\\temp\\ACT11_4.csv");  // llegir l'arxiu i insertar a BBDD
            
            System.out.println("Connexió tancada.");
        } catch (Exception e) {
            System.err.println("S'ha produït l'error general: " + e.getMessage());
        }
    }
    
    public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
        String servidor = "";
        String bdades = "";
        String usuari = "";
        String passwd = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                try {
                    String[] parts = linia.split("=");
                    String clau = parts[0].trim();
                    String valor = (parts[1] == null ? "" : parts[1].trim());  // cas de 'PASSWD = '
                    
                    switch (clau) {
                        case "SERVER" -> servidor = valor;
                        case "DBASE" -> bdades = valor;
                        case "USER" -> usuari = valor;
                        case "PASSWD" -> passwd = valor;
                        default -> System.err.println("Clau no vàlida: " + clau);
                    }
                } catch (IndexOutOfBoundsException e) {
                    // En cas de '#', l'split no funciona
                    // No fer res
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection(servidor + bdades, usuari, passwd);
    }
    
    public static void arxiuABBDD(Connection connexio, String filename) throws SQLException, IOException {
        int numLinia = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();  // Es descarta la primera línia
            while ((line = reader.readLine()) != null) {
                try {
                    numLinia = numLinia + 1 ;
                    
                    String[] parts = line.split(";");
                    String _departmentId = parts[0];
                    String _departmentName = parts[1];
                    String _managerId = parts[2];
                    String _locationId = parts[3];
                    
                    String sql="";
                    PreparedStatement statement;
                    ResultSet resultSet;
                    
                    // Comprovar integritat referencial amb 'employees'
                    sql = """
                          SELECT 'dummy' FROM employees
                          WHERE employee_id = ?
                          """;
                    statement = connexio.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(_managerId));
                    resultSet = statement.executeQuery();
                    
                    if (!resultSet.next())
                        throw new SQLException("Error, empleat no existeix " + _managerId);
                    
                    // Comprovar integritat referencial amb 'locations'
                    sql = """
                          SELECT '1'
                          FROM locations
                          WHERE location_id = ?
                          """;
                    statement = connexio.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(_locationId));
                    resultSet = statement.executeQuery();
                    
                    if (!resultSet.next())
                        throw new SQLException("Error, location no existeix " + _locationId);
                    
                    // Insertar la fila a 'departments'
                    try {
                        sql = """
                              INSERT INTO departments (department_id, department_name, manager_id, location_id)
                              VALUES (?, ?, ?, ?)
                              """;
                        statement = connexio.prepareStatement(sql);
                        statement.setInt(1, Integer.parseInt(_departmentId));
                        statement.setString(2, _departmentName);
                        statement.setInt(3, Integer.parseInt(_managerId));
                        statement.setInt(4, Integer.parseInt(_locationId));
                        statement.executeUpdate();
                    } catch (SQLException e) {  // per a qualsevol error ...
                        if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) { // ... excepte l'error per PK
                            // Modificar
                            sql = """
                                  UPDATE departments 
                                  SET department_name = ?,
                                      manager_id = ?,
                                      location_id = ?
                                  WHERE department_id = ?
                                  """;
                            statement = connexio.prepareStatement(sql);
                            statement.setString(1, _departmentName);
                            statement.setInt(2, Integer.parseInt(_managerId));
                            statement.setInt(3, Integer.parseInt(_locationId));
                            statement.setInt(4, Integer.parseInt(_departmentId));
                            statement.executeUpdate();
                        } else  
                            throw e;
                    }   
                    connexio.commit();
                } catch (SQLException e) {
                    connexio.rollback();
                    System.err.println("Error carregant Línia" + numLinia + ": " + e.getMessage());;
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Línia" + numLinia + ": " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error carregant Línia" + numLinia + ": " + e.getMessage());   
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e; // Es propaga l'excepció al mètode anterior
        }
    }
}