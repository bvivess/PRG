package com.mycompany.mavenproject1;

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
        File arxiuJson = new File("C:\\temp\\personas.json");

        try {
            List<Persona> persones = objectMapper.readValue(arxiuJson, new TypeReference<List<Persona>>() {});
            for (Persona persona : persones) {  // Iterar sobre la lista de personas
                System.out.println("Codi: " + persona.getIdPersona());
                System.out.println("Nom: " + persona.getNom());
                System.out.println("Llinatge: " + persona.getLlinatge());
                System.out.println("Edat: " + persona.getEdat());
                // Iterar la llista d'aficions
                List<String> aficions = persona.getAficions();
                for (String a : aficions) 
                    System.out.println("\tAfició: " + a);
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}