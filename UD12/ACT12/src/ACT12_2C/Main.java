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
        
        // Carrega les llistes
        List<String[]> liniesCSV = llegeixLiniesCSV("c:\\temp\\clients.csv");
        List<Department> departments = carregaDepartments(liniesCSV);
        List<Client> clients = carregaClients(liniesCSV);
        
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
    
    private static List<String[]> llegeixLiniesCSV(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            return linies
                    .filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                    .map(linia -> linia.split(","))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return List.of();  // retorna llista buida en cas d’error
    }

    private static List<Department> carregaDepartments(List<String[]> linies) {
        return linies.stream()
                .map(parts -> parts[3].trim())
                .distinct()
                .map(Department::new)
                .sorted((d1, d2) -> d1.getId().compareTo(d2.getId()))
                .collect(Collectors.toList());
    }

    private static List<Client> carregaClients(List<String[]> linies) {
        return linies.stream()
                .map(parts -> new Client(
                        Integer.parseInt(parts[0].trim()),
                        parts[1].trim(),
                        parts[2].trim()))
                .sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom()))
                .collect(Collectors.toList());
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
            System.err.println(e.getMessage());
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
            System.err.println(e.getMessage());
        }
    }
            
}