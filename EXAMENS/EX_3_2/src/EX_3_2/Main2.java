package EX_3_2;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = llegirVehiclesCSV("c:\\temp\\vehicles.csv");

        long total = vehicles.stream()
                             .filter(v -> v.getPreu() > 15000)
                             .count();

        double preuMitja = vehicles.stream()
                                   .map(v->v.getPreu())
                                   .mapToDouble(n->n)
                                   .average().orElse(0);

        double preuMesCar = vehicles.stream()
                                    .map(v->v.getPreu())
                                    .mapToDouble(n->n)
                                    .max()
                                    .orElse(0);

        double preuMesBarat = vehicles.stream()
                                      .map(v->v.getPreu())
                                      .mapToDouble(n->n)
                                      .min()
                                      .orElse(0);

        System.out.println("Vehicles > 15000 EUR: " + total);
        System.out.println("Preu mitja: " + preuMitja);
        System.out.println("Mes car: " + preuMesCar);
        System.out.println("Mes barat: " + preuMesBarat);
    }

    private static List<Vehicle> llegirVehiclesCSV(String fitxer) {
        try (Stream<String> stream = Files.lines(Path.of(fitxer))) {
            return stream.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                         .map(linia -> linia.split(","))
                         .map(p -> new Vehicle(
                                       p[0].trim(), 
                                       p[1].trim(), 
                                       p[2].trim(), 
                                       Integer.parseInt(p[3].trim()), 
                                       Double.parseDouble(p[4]))
                                      )
                         .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

