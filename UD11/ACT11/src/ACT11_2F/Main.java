package ACT11_2F;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String arxiu = "C:\\temp\\Meteorite_Landings.csv";
        String arxiuLog = "C:\\temp\\Meteorite.log";
        Set<Meteorit> meteorits = new HashSet<>();
        Map<Integer, List<Meteorit>> meteoritsPerAny = new HashMap<>();

        try {
            llegeixArxiu(arxiu, arxiuLog, meteorits, meteoritsPerAny);

            // 1. > 1000g
            System.out.println("METEORITS > 1kg:");
            for (Meteorit m : meteorits) {
                if (m.getType().equals("Valid") && m.getMass() > 1000) {
                    System.out.println(m);
                }
            }

            // 2. per any, ordenat
            System.out.println("\nTOTAL PER ANY:");
            List<Integer> anys = new ArrayList<>(meteoritsPerAny.keySet());
            Collections.sort(anys);
            for (Integer any : anys) {
                List<Meteorit> llista = meteoritsPerAny.get(any);
                System.out.println("Any: " + any + " -> Total: " + llista.size());
            }

            // 3. més pesat
            Meteorit mMax = null;
            for (Meteorit m : meteorits) {
                if (mMax == null || m.getMass() > mMax.getMass()) {
                    mMax = m;
                }
            }
            System.out.println("\nMÉS PESAT: " + mMax);

            // 4. ordenats per nom
            System.out.println("\nORDENATS:");
            List<Meteorit> llistaOrdenada = new ArrayList<>(meteorits);
            Collections.sort(llistaOrdenada); 
            System.out.println(llistaOrdenada);
            /*
            for (Meteorit m : llistaOrdenada) {
                System.out.println(m);
            }*/
            llistaOrdenada = null;
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }

    public static void llegeixArxiu(String arxiu, String arxiuLog, Set<Meteorit> meteorits, Map<Integer, List<Meteorit>> meteoritsPerAny) throws IOException {

        String linia;
        int numLinia = 0;

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {   
            while ((linia = bufferedReader.readLine()) != null) {
                try {
                    numLinia++;

                    String[] parts = linia.split(",");

                    int _id = Integer.parseInt(parts[1].trim());
                    String _nom = parts[0].trim();
                    String _type = parts[2].trim();
                    double _massa = parts[4].isEmpty() ? 0 : Double.parseDouble(parts[4].trim());
                    String _fell = parts[5].trim();
                    int _any = parts[6].isEmpty() ? 0 : Integer.parseInt(parts[6].trim());
                    LocalDate _data = (_any == 0) ? null : LocalDate.of(_any, 1, 1);
                    double _latitude = parts[7].isEmpty() ? 0 : Double.parseDouble(parts[7].trim());
                    double _longitude = parts[8].isEmpty() ? 0 : Double.parseDouble(parts[8].trim());

                    Meteorit m = new Meteorit(_id, _nom, _type, _massa, _fell, _data, _latitude, _longitude);

                    // Afegir al Set
                    meteorits.add(m);

                    // Afegeix al Map
                    if (!meteoritsPerAny.containsKey(_any)) {
                        meteoritsPerAny.put(_any, new ArrayList<Meteorit>());
                    }
                    meteoritsPerAny.get(_any).add(m);
                    
                } catch (NumberFormatException e) {
                    bufferedWriter.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (IllegalArgumentException e) {
                    bufferedWriter.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (Exception e) {
                    bufferedWriter.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();
                }
            }

        }
    }
}
