package ACT11_2A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws Exception {
        String arxiu = "C:\\temp\\ACT11_2A.cvs";
        Map<Integer, Persona> persones;

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
            ) {
            
            // Llegir el contingut l�nia a l�nia
            persones = LlegeixArxiu(bufferedReader);
            
            // Mostrar el map
            MostraPersones(persones);

        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static Map<Integer,Persona> LlegeixArxiu(BufferedReader bufferedReader) throws IOException, Exception {
        Map<Integer,Persona> persones = new HashMap<>();
        String linea;
        String[] parts;
        Integer clau;
        Persona persona;
        
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: xxxx; yyyy; zzzz; ...
                if (!(linea.isEmpty() || linea.startsWith("#"))) {
                    parts = linea.split(";");
                    if (!linea.substring(0, 1).equals("#")) {
                        clau = Integer.valueOf(parts[0]);
                        persona = new Persona(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]);
                        persones.put(clau, persona);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error carragant Persona: " + e.getMessage());
            }
        }
        return persones;
    }

    private static void MostraPersones(Map<Integer,Persona> persones) {
        for (Integer k : persones.keySet()) {
            Persona v = persones.get(k);
            System.out.println(k + " = " + v);
        }
    }

}

