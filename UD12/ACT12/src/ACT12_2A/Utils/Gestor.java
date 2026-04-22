package ACT12_2A.Utils;

import ACT12_2A.Classes.Client;
import ACT12_2A.Classes.Department;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Gestor {
    public List<Department> carregaDepartments(String f) {
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
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public List<Client> carregaClients(String f) {
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
            System.err.println(e.getMessage());
        }
        return null;
    }
}
