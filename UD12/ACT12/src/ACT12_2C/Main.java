package ACT12_2C;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        
        List<Department> departments;
        List<Client> clients;
        
        // Carrega les llistes
        departments = carregaDepartments("c:\\temp\\clients.csv");
        clients = carregaClients("c:\\temp\\clients.csv");
        
        // Imprimeix la llista
        System.out.println("Departaments");
        departments.stream().forEach(System.out::println);  // Ordenat per Id
        System.out.println("");
        System.out.println("Clients");
        clients.stream().forEach(System.out::println);  // Ordenat per nom
        
        // Desa les llistes
        desaDepartments(gestorBBDD, departments);
        desaClients(gestorBBDD, clients);
        
        System.out.println("BBDD modificada correctament");
    }
    
    private static List<Department> carregaDepartments(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            List<Department> departments = 
                   linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .map(parts -> parts[3].trim())
                  .distinct()
                  .map(d -> new Department(d))
                  .sorted((d1, d2) -> d1.getId().compareTo(d2.getId()))
                  .collect(Collectors.toList());  
            return departments;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static List<Client> carregaClients(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            List<Client> clients = 
                   linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .map(parts -> new Client( Integer.parseInt(parts[0].trim()),
                                            parts[1].trim(),
                                            parts[2].trim()
                                          )
                      )
                  .sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom()))
                  .collect(Collectors.toList()); 
            return clients;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static void desaDepartments(GestorBBDD gestorBBDD, List<Department> departments) {
        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            departments.stream()
                  .forEach(d -> {
                      try {
                          gestorBBDD.executaSQL(conn,
                                  "INSERT INTO departaments (id) VALUES (?)",
                                  d.getId() );

                      } catch (SQLException e) {
                            if (!((e.getSQLState().equals("23000") && e.getErrorCode() == 1062)))
                                throw new RuntimeException(e);
                      }
                  });

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void desaClients(GestorBBDD gestorBBDD, List<Client> clients) {
        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            clients.stream()
                  .forEach(c -> {
                      try {
                          gestorBBDD.executaSQL(conn,
                                  "INSERT INTO clients (id, nom, email) VALUES (?, ?, ?)",
                                  c.getId(), c.getNom(),c.getEmail().trim());

                      } catch (SQLException e) {
                          try {
                              if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                                  // Clau primària duplicada → fem UPDATE
                                  int id = c.getId();
                                  String nom = c.getNom().toUpperCase().trim();
                                  String email = c.getEmail().toLowerCase().trim();

                                  gestorBBDD.executaSQL(conn,
                                          "UPDATE clients SET nom = ?, email = ? WHERE id = ?",
                                          nom, email, id);
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




