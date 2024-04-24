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
        Map<LocalDateTime, MissatgeEvent> events = new TreeMap<>();

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
            ) {
            
            // Llegir el contingut línia a línia
            events = LlegeixArxiu(bufferedReader);
            LlegeixVariables(events);
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static Map<LocalDateTime,MissatgeEvent> LlegeixArxiu(BufferedReader bufferedReader) throws IOException {
        Map<LocalDateTime, MissatgeEvent> events = new TreeMap<>();
        String linea;
        String[] parts;
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: YYYY-MM-DD hh:mi:ss | xxxxx | xxxxx | xxxxx | xxxxx | xxxxx
                // Descomposició de l'string
                parts = linea.split("\\|", 6);  // el separador és '|'
                String data = parts[0].substring(0,10);  // en format: yyyy-MM-dd
                String hora = parts[0].substring(11,19);  // en format: HH:mi:ss
                LocalDateTime diaHora = LocalDateTime.parse(data + " " + hora,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // Obtener el tipo de error
                String ipOrigen = parts[1];

                // Obtener el código de error
                String portOrigen = parts[2];
                
                // Obtener el tipo de error
                String ipDesti = parts[3];

                // Obtener el código de error
                String portDesti = parts[4];

                // Obtener la descripción
                String descripcio = parts[5];
                MissatgeEvent missatgeError = new MissatgeEvent(ipOrigen, portOrigen, ipDesti, portDesti, descripcio);
                events.put(diaHora, missatgeError);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return events;
    }

    private static void LlegeixVariables(Map<LocalDateTime,MissatgeEvent> variables) {
        for (LocalDateTime k : variables.keySet()) {
            MissatgeEvent v = variables.get(k);
            System.out.println(k + " = " + v.toString());
        }
    }

}

