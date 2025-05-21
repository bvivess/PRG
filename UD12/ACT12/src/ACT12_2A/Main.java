 package ACT12_2A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Department> departments;
        List<Client> clients;
        
        departments = carregaDepartments("c:\\temp\\clients.csv");
        clients = carregaClients("c:\\temp\\clients.csv");
        
        // Imprimeix la llista
        System.out.println("Departments");
        departments.stream().sorted((d1, d2) -> d1.getId().compareTo(d2.getId())).forEach(System.out::println);  // Ordenat per Id
        
        System.out.println("");
        
        // Imprimeix la llista
        System.out.println("Clients");
        clients.stream().sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom())).forEach(System.out::println);  // Ordenat per nom
    }
    
    private static List<Department> carregaDepartments(String f) {
        try (Stream<String> linies = Files.lines(Paths.get(f))) {
            List<Department> departments = 
                   linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .map(parts -> parts[3].trim())
                  .distinct()
                  .map(d -> new Department(d))
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
                  .collect(Collectors.toList()); 
            return clients;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}