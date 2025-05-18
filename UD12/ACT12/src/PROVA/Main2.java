package PROVA;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = llegirVehiclesCSV("c:\\temp\\vehicles.csv");

        long countCars = vehicles.stream()
                                 .filter(v -> v.getPreu() > 15000)
                                 .count();

        double preuMitja = vehicles.stream()
                                   .collect(Collectors.averagingDouble(Vehicle::getPreu));

        Vehicle mesCar = vehicles.stream()
                                 .max(Comparator.comparingDouble(Vehicle::getPreu))
                                 .orElse(null);

        Vehicle mesBarat = vehicles.stream()
                                   .min(Comparator.comparingDouble(Vehicle::getPreu))
                                   .orElse(null);

        System.out.println("Vehicles > 15000 EUR: " + countCars);
        System.out.printf("Preu mitja: ", preuMitja);
        System.out.println("Mes car: " + mesCar);
        System.out.println("Mes barat: " + mesBarat);
    }

    private static List<Vehicle> llegirVehiclesCSV(String fitxer) {
        try (Stream<String> stream = Files.lines(Path.of(fitxer))) {
            return stream.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                         .map(linia -> linia.split(","))
                         .map(p -> new Vehicle( p[0].trim(), 
                                       p[1].trim(), 
                                       Integer.parseInt(p[2].trim()), 
                                       Double.parseDouble(p[3]))
                                      )
                         .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

