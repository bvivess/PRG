package ACT12_0C;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File arxiuJson = new File("arxiu.json");

        try {
            List<Persona> persones = objectMapper.readValue(arxiuJson, new TypeReference<List<Persona>>() {});
            for (Persona persona : persones) {  // Iterar sobre la lista de personas
                System.out.println("Nom: " + persona.getNom());
                System.out.println("Edat: " + persona.getEdat());
                System.out.println("Aficions: " + persona.getAficions());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
