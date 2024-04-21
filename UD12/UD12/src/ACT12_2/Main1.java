package ACT12_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\temp\\ACT12_2.cfg";
        Map<String, String> variables = new HashMap<>();

        try ( FileReader fileReader = new FileReader(rutaArchivo);
              BufferedReader bufferedReader = new BufferedReader(fileReader);
            ) {

            // Llegir el contingut línia a línia
            String linea;
            String clau = "";
            String valor = "";
            while ((linea = bufferedReader.readLine()) != null) {
                // format: xxxx = yyyy
                clau = linea.substring(0, linea.indexOf('=')).trim();
                valor = linea.substring(linea.indexOf('=') + 1).trim();
                variables.put(clau, valor);
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
}

