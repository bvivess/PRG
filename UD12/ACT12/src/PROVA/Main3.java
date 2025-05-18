package PROVA;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = llegirVehiclesCSV("c:\\temp\\vehicles.csv"); // o llista inventada

        Map<String, List<Vehicle>> perMarca = vehicles.stream()
            .collect(Collectors.groupingBy(Vehicle::getMarca));

        perMarca.forEach((marca, llista) ->
            System.out.println(marca + " - " + llista.size() + " vehicles"));
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

