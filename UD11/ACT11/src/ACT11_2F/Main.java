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
            meteorits.stream()
                    .filter(m -> m.getMass() > 1000)
                    .forEach(System.out::println);

            // 2. per any
            System.out.println("\nCOUNT PER YEAR:");
            meteoritsPerAny.forEach((year, list) ->
                    System.out.println(year + " -> " + list.size()));

            // 3. mÃ©s pesat
            Meteorit max = meteorits.stream()
                    .max(Comparator.comparingDouble(Meteorit::getMass))
                    .orElse(null);

            System.out.println("\nMÃ‰S PESAT: " + max);

            // 4. ordenats per nom
            System.out.println("\nORDENATS:");
            meteorits.stream()
                    .sorted()
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }

    public static void llegeixArxiu(String arxiu,
                                    String arxiuLog,
                                    Set<Meteorit> meteorits,
                                    Map<Integer, List<Meteorit>> meteoritsPerAny)
            throws IOException {

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) { 

            String linia;
            int numLinia = 0;
            bufferedReader.readLine(); // header

            while ((linia = bufferedReader.readLine()) != null) {

                try {
                    // Format: xxx,xxx,xxx ...
                    numLinia = numLinia + 1 ;
                    
                    String[] parts = linia.split(",");

                    int _id = Integer.parseInt(parts[1].trim());
                    String _nom = parts[0].trim();
                    double _massa = parts[4].isEmpty() ? 0 : Double.parseDouble(parts[4].trim());
                    int _any = parts[6].isEmpty() ? 0 : Integer.parseInt(parts[6].trim());
                    LocalDate _data = (_any == 0) ? null : LocalDate.of(_any, 1, 1);
                    double _latitude = parts[7].isEmpty() ? 0 : Double.parseDouble(parts[7].trim());
                    double _longitude = parts[8].isEmpty() ? 0 : Double.parseDouble(parts[8].trim());

                    Meteorit m = new Meteorit(_id, _nom, _massa, _data, _latitude, _longitude);

                    meteorits.add(m);
                    meteoritsPerAny
                            .computeIfAbsent(_any, k -> new ArrayList<>())
                            .add(m);

                } catch (NumberFormatException e) {
                    bufferedWriter.write("Error carregant Línia" + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (IllegalArgumentException e) {
                    bufferedWriter.write("Error carregant Línia" + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (Exception e) {
                    bufferedWriter.write("Error carregant Línia" + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();   
                }
            }
        }
    }
}
