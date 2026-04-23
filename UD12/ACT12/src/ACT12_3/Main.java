package ACT12_3;

import ACT12_3.Utils.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Gestor gestor = new Gestor();
        String arxiu = "C:\\temp\\Meteorite_Landings.csv";
        String arxiuLog = "C:\\temp\\Meteorite.log";
        Set<Meteorit> meteorits = new HashSet<>();
        Map<Integer, List<Meteorit>> meteoritsPerAny = new HashMap<>();

        try {
            meteorits = gestor.llegeixArxiu(arxiu, arxiuLog);
            
            // 1. > 1000g
            System.out.println("METEORITS > 1kg:");
            meteorits.stream()
                    .filter(m -> m.getMass() > 1000)
                    .forEach(System.out::println);

            // 2. per any
            System.out.println("\nCOUNT PER YEAR:");
            meteoritsPerAny.forEach((year, list) ->
                    System.out.println(year + " -> " + list.size()));

            // 3. més pesat
            Meteorit max = meteorits.stream()
                    .max(Comparator.comparingDouble(Meteorit::getMass))
                    .orElse(null);

            System.out.println("\nMÉS PESAT: " + max);

            // 4. ordenats per nom
            System.out.println("\nORDENATS:");
            meteorits.stream()
                    .sorted()
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }
}
