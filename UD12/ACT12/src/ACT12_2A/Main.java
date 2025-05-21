 package ACT12_2A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (Stream<String> linies = Files.lines(Paths.get("c:\\temp\\clients.csv"))) {
            List<Department> departments = 
                   linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .map(parts -> parts[3].trim())
                  .distinct()
                  .map(d -> new Department(d))
                  .collect(Collectors.toList());
         
            // Imprimeix la llista
            departments.stream().sorted((d1, d2) -> d1.getId().compareTo(d2.getId())).forEach(System.out::println);  // Ordenat per Id
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (Stream<String> linies = Files.lines(Paths.get("c:\\temp\\clients.csv"))) {
            List<Client> clients = 
                   linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .map(parts -> new Client( Integer.parseInt(parts[0].trim()),
                                            parts[1].trim(),
                                            parts[2].trim()
                                          )
                      )
                  .collect(Collectors.toList());

            // Imprimeix la llista
            clients.stream().sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom())).forEach(System.out::println);  // Ordenat per nom
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

