package ACT12_3B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String arxiu = "C:\\temp\\ACT12_3B.log";
        Map<LocalDateTime, MissatgeError> variables = new TreeMap<>();

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
            ) {
            
            // Llegir el contingut l�nia a l�nia
            variables = LlegeixArxiu(bufferedReader);
            LlegeixVariables(variables);
            //if (ComprovaVariables(variables))
            //    System.out.println("OK");
            //else
            //    System.out.println("KO");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static Map<LocalDateTime,MissatgeError> LlegeixArxiu(BufferedReader bufferedReader) throws IOException {
        Map<LocalDateTime, MissatgeError> variables = new TreeMap<>();
        String linea;
        String[] parts;
        int i=0;
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: YYYY-MM-DD hh:mi:ss [tipus:9999] xxxxxxxxxxxxxxxxxxxxxxxxxxx
                // Descomposici� de l'string
                parts = linea.split("\\|", 6);  // tants espais en blanc '\s+' com sigui possible
                System.out.println(parts[0].substring(0,10) + " " + parts[0].substring(11,19));
                System.out.println("Linia " + ++i);
                LocalDateTime diaHora = LocalDateTime.parse(parts[0].substring(0,10) + " " + parts[0].substring(11,19), 
                                                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // Obtener el tipo de error
                String ipOrigen = parts[1];

                // Obtener el c�digo de error
                String portOrigen = parts[2];
                
                // Obtener el tipo de error
                String ipDesti = parts[3];

                // Obtener el c�digo de error
                String portDesti = parts[4];

                // Obtener la descripci�n
                String descripcio = parts[5];
                MissatgeError missatgeError = new MissatgeError(ipOrigen, portOrigen, ipDesti, portDesti, descripcio);
                variables.put(diaHora, missatgeError);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return variables;
    }

    private static void LlegeixVariables(Map<LocalDateTime,MissatgeError> variables) {
        for (LocalDateTime k : variables.keySet()) {
            MissatgeError v = variables.get(k);
            System.out.println(k + " = " + v.toString());
        }
    }

}

