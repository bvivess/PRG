package ACT12_3;

import ACT12_3.Classes.*;
import ACT12_3.Utils.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
   
    public static void main(String[] args) throws Exception {
        GestorMeteorits gestor = new GestorMeteorits();

        String arxiu = "C:\\temp\\Meteorite_Landings.csv";
        String arxiuLog = "C:\\temp\\Meteorite_Landings.log";
        

        try {
            meteorits = gestor.llegeixArxiuCSV(arxiu, arxiuLog);  // 'llegeixArxiuCSV' ja torna el Set 
            // Per a cada meteorit, es carrega la seva posició a 'geoPositions'
            for (Meteorit m : meteorits) {
                geoPositions.add(m.getGeoPosition());
            }
            
            // 1. > 1000g
            System.out.println("METEORITS > 1kg (v?lids):");
            System.out.println( meteorits.stream()
                                         .filter(m -> m.getMass() > 1000 && m.getType().equals("Valid") )
                                         .count() );

            // 2. per any
            System.out.println("\nCOUNT PER YEAR:");
            Map<Integer, List<Meteorit>> meteoritsPerAny = new HashMap<>();
            meteoritsPerAny = meteorits.stream()
                                       .collect( Collectors.groupingBy(m -> m.getYear()) );
            
            meteoritsPerAny.entrySet().stream()
                                      .sorted(Map.Entry.comparingByKey())  // ordenar les 'entrySet' per 'Key'
                                      .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue().size()));

            // 3. més pesat
            Meteorit max = meteorits.stream()
                                    .max(Comparator.comparingDouble(m -> m.getMass()))
                                    .orElse(null);

            System.out.println("\nMÉS PESAT: " + max);

            // 4. caiguts en Europa
            System.out.println("\nCAIGUTS EN EUROPA: ");
            List<Meteorit> europeus = meteorits.stream()
                                               .filter(m -> (m.getGeoPosition().getLatitude()  >=  35 && m.getGeoPosition().getLatitude() <= 71) && 
                                                            (m.getGeoPosition().getLongitude() >= -25 && m.getGeoPosition().getLongitude() <= 40))
                                               .toList();
            
            europeus.stream().forEach(System.out::println);
            
            // 4. caiguts en Espanya
            System.out.println("\nCAIGUTS EN ESPANYA: ");
            List<Meteorit> mallorquins = meteorits.stream()
                                                   .filter(m -> (m.getGeoPosition().getLatitude()  >= 36 && m.getGeoPosition().getLatitude() <= 4) &&
                                                                (m.getGeoPosition().getLongitude() >= -9 && m.getGeoPosition().getLongitude() <= 3))
                                                   .toList();
            
            mallorquins.stream().forEach(System.out::println);
            
            /*
            // 4. ordenats per nom
            System.out.println("\nORDENATS:");
            meteorits.stream()
                       .sorted()
                     .forEach(System.out::println);
            */
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }
    
}
