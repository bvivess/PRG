package ACT12_2C.Utils;

import ACT12_2C.Classes.Client;
import ACT12_2C.Classes.Department;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Gestor {
    
    public List<Department> carregaDepartamentsCSV(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            return linies
                    // PARSE
                    .filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                    .map(linia -> linia.split(","))
                    .map(parts -> parts[3].trim())
                    .distinct()
                    .map(id -> new Department( id ))  // .map(Department::new)
                    // FI PARSE
                    .sorted((d1, d2) -> d1.getId().compareTo(d2.getId()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;  // retorna llista buida en cas d'error
    }

    public List<Client> carregaClientsCSV(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            return linies
                    // PARSE
                    .filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                    .map(linia -> linia.split(","))
                    .map(parts -> new Client( Integer.parseInt(parts[0].trim()),
                                              parts[1].trim(),
                                              parts[2].trim(),
                                              parts[3].trim()) )
                    // FI PARSE
                    .sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;  // retorna llista buida en cas d'error
    }
    
    public void desaDepartments(GestorBBDD gestorBBDD, List<Department> departments) {
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
    
    public void desaClients(GestorBBDD gestorBBDD, List<Client> clients) {
        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            clients.stream()
                   .forEach(c -> {
                      try {
                          gestorBBDD.executaSQL(conn,
                                  "INSERT INTO clients (id, nom, email, departament_id) VALUES (?, ?, ?, ?)",
                                  c.getId(), c.getNom(), c.getEmail(), c.getDepartment_id());

                      } catch (SQLException e) {
                          try {
                              if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                                  // Clau prim?ria duplicada, fem UPDATE
                                  gestorBBDD.executaSQL(conn,
                                          "UPDATE clients SET nom = ?, email = ?, departament_id = ? WHERE id = ?",
                                          c.getNom(), c.getEmail(), c.getDepartment_id(), c.getId());
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
