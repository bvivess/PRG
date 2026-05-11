package ACT12_2A.Utils;

import ACT12_2A.Classes.Client;
import ACT12_2A.Classes.Department;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Gestor {
    public List<Department> carregaDepartments(String arxiu) {
        try (Stream<String> linies = Files.lines(Paths.get(arxiu))) {
            return linies
                    .map(linia -> parseDepartment(linia))
                    .filter(obj -> obj != null)  // s'eliminen els possibles errors del 'parseDepartment'
                    .distinct()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    private Department parseDepartment(String linia) {
        if (linia.isBlank() || linia.startsWith("#")) {
            return null;
        } else {
            String[] parts = linia.split(",");
            return new Department(parts[3].trim());
        }
    }    
    
    public List<Client> carregaClients(String arxiu) {
        try (Stream<String> linies = Files.lines(Paths.get(arxiu))) {
            return linies
                    .map(linia -> parseClient(linia))
                    .filter(Objects::nonNull)  // s'eliminen els possibles errors de 'parseClient'
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }    
    private Client parseClient(String linia) {
        if (linia.isBlank() || linia.startsWith("#")) {
            return null;
        } else {
            String[] parts = linia.split(",");
            return new Client(
                    Integer.parseInt(parts[0].trim()),
                    parts[1].trim(),
                    parts[2].trim()
            );
        }
    }
}
