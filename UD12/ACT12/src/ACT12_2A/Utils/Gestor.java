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
                    .filter(d -> d != null)  // s'eliminen els possibles errors del 'parseDepartment'
                    .distinct()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    private Department parseDepartment(String linia) {
        try {
            if (!(linia.isBlank() || linia.startsWith("#"))) {
                String[] parts = linia.split(",");
                return new Department( parts[3].trim() );
            }
        } catch(Exception e) {
            System.out.println("Error en línia: " + linia + ": " + e.getMessage());
        }
        return null;
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
        try {
            if (!(linia.isBlank() || linia.startsWith("#"))) {
                String[] parts = linia.split(",");
                return new Client( Integer.parseInt(parts[0].trim()),
                                   parts[1].trim(),
                                   parts[2].trim() );
            }
        } catch(Exception e) {
            System.out.println("Error en línia: " + linia + ": " + e.getMessage());
        }
        return null;
    }
}
