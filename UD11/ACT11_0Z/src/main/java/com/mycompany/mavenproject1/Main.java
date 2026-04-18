package com.mycompany.mavenproject1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String arxiuJSON = "C:\\temp\\persones.json";
    static String arxiuJSON2 = "C:\\temp\\persones2.json";
    static File fileJSON = new File(arxiuJSON);

    public static void main(String[] args) {
        List<Persona> persones;
        
        persones = lecturaJSON();  // en aquest cas, 'persones' no té sentit que sigui un paràmetre d'entrada ja que 'readValue()' crea una nova referència 
        modificacioJSON(persones);
        escripturaJSON(persones);
        
        System.out.println("PERSONES");
        System.out.println(persones);
    }

    private static List<Persona> lecturaJSON() {
        List<Persona> persones = new ArrayList<>();  // Crear la List de tornada
        ObjectMapper objectMapper = new ObjectMapper();  // Crear un ObjectMapper
        
        try {
            persones = objectMapper.readValue(fileJSON, new TypeReference<List<Persona>>() {});  // NOTA: es perd la referència de 'persones' perquè se'n crea una altra
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persones;
    }
    
   private static void modificacioJSON(List<Persona> persones) {
        for (Persona p : persones) {
            p.setLlinatge(p.getLlinatge().toUpperCase());
            p.setNom(p.getNom().toUpperCase());
        }
    }
 
    private static void escripturaJSON(List<Persona> persones) {
        // Crear un ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            objectMapper.writeValue(new File(arxiuJSON2), persones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}