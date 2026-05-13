package ACT12_2C.Utils;

import ACT12_2C.Classes.Client;
import ACT12_2C.Classes.Department;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gestor {
    
    public List<Department> carregaDepartamentsCSV(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            return linies
                    .map(linia -> parseDepartament(linia))
                    .filter(Objects::nonNull)
                    .distinct()
                    .sorted((d1, d2) -> d1.getId().compareTo(d2.getId()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private Department parseDepartament(String linia) {
        try {
            if (linia.isBlank() || linia.startsWith("#"))
                return null;
            else {
                String[] parts = linia.split(",");
                return new Department(parts[3].trim());
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en linia: " + linia + ": " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en linia: " + linia + ": " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en linia: " + linia + ": " + e.getMessage());
        }
        return null;
    }

    public List<Client> carregaClientsCSV(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            return linies
                    .map(linia -> parseClient(linia))
                    .filter(Objects::nonNull)
                    .sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private Client parseClient(String linia) {
        try {
            if (linia.isBlank() || linia.startsWith("#"))
                return null;
            else {
                String[] parts = linia.split(",");
                try {
                    return new Client( Integer.parseInt(parts[0].trim()),
                                       parts[1].trim(),
                                       parts[2].trim(),
                                       parts[3].trim() );
                } catch (NumberFormatException e) {
                    System.err.println("Error en línia: " + linia);
                    return null;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en linia: " + linia + ": " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en linia: " + linia + ": " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en linia: " + linia + ": " + e.getMessage());
        }
        return null;
    }
    
    public void desaDepartments(GestorBBDD gestorBBDD, List<Department> departments) {
        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            departments.stream()                       
                       .forEach(d -> {
                            try {
                                gestorBBDD.executaSQL( conn,
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
                          gestorBBDD.executaSQL( conn,
                                                 "INSERT INTO clients (id, nom, email, departament_id) VALUES (?, ?, ?, ?)",
                                                 c.getId(), c.getNom(), c.getEmail(), c.getDepartment_id() );
                      } catch (SQLException e) {
                          try {
                              if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                                  // Clau prim?ria duplicada, fem UPDATE
                                  gestorBBDD.executaSQL( conn,
                                                         "UPDATE clients SET nom = ?, email = ?, departament_id = ? WHERE id = ?",
                                                         c.getNom(), c.getEmail(), c.getDepartment_id(), c.getId() );
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
