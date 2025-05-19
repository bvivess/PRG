package EX_3_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        
        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("4321-JKL", "Ford",     "Focus",   2019, 17000),
                new Vehicle("8765-MNO", "Hyundai",  "Ioniq 5", 2023, 42000),
                new Vehicle("2109-PQR", "Peugeot",  "308",     2016, 14000)
            );

            vehicles.stream().forEach(v -> {
                      try {
                          gestorBBDD.executaSQL(conn,
                                  "INSERT INTO vehicles (matricula, marca, model, any, preu) VALUES (?, ?, ?, ?, ?)",
                                  v.getMatricula(), v.getMarca(), v.getModel(), (Integer) v.getAny(), (Double) v.getPreu());

                      } catch (SQLException e) {
                          try {
                              if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                                  // Clau primària duplicada → fem UPDATE
                                  gestorBBDD.executaSQL(conn,
                                          "UPDATE vehicles SET marca = ?, model = ?, any = ?, preu = ? WHERE matricula = ?",
                                          v.getMarca().toUpperCase(), v.getModel().toUpperCase(), (Integer) v.getAny(), (Double) v.getPreu(), v.getMatricula() );
                              } else {
                                  throw new RuntimeException(e);
                              }
                          } catch (SQLException e2) {
                              throw new RuntimeException(e2);
                          }
                      }
                  });

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
