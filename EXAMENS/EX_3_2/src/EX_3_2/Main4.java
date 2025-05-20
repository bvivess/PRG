package EX_3_2;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        List<Vehicle> vehicles = new ArrayList<>();
        
        String sql = "SELECT matricula, marca, model, any, preu FROM vehicles WHERE any >= ?";
             
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql, (Integer) 2020 ) ) { 
            
            while (resultSet.next()) 
                vehicles.add(new Vehicle( resultSet.getString("matricula"),
                                          resultSet.getString("marca"), 
                                          resultSet.getString("model"),
                                          resultSet.getInt("any"),
                                          resultSet.getDouble("preu") ) 
                            );
            
            vehicles.stream().forEach(System.out::println);
            
        } catch (SQLException e) {
            System.err.println("Error carregant vehicles BBDD: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error carregant vehicles BBDD: " + e.getMessage());
        }
    }
    
}