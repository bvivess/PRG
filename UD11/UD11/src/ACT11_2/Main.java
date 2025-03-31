package ACT11_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\temp\\ACT11_2.cvs";
        Map<Integer, Persona> variables = new HashMap<>();
        String[] parts;

        try ( FileReader fileReader = new FileReader(rutaArchivo);
              BufferedReader bufferedReader = new BufferedReader(fileReader);
            ) {

            // Llegir el contingut línia a línia
            String linea;
            Integer clau;
            Persona persona;
            while ((linea = bufferedReader.readLine()) != null) {
                parts = linea.split("=");
                if (!linea.substring(0, 1).equals("#")) {
                    clau = Integer.valueOf(parts[0]);
                    persona = new Persona(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]);
                    variables.put(clau, persona);
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
}

