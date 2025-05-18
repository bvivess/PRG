package PROVA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
            new Vehicle("Toyota", "Corolla", 2010, 12000),
            new Vehicle("Volkswagen", "Golf", 2018, 18000),
            new Vehicle("Seat", "Ibiza", 2015, 10000),
            new Vehicle("Tesla", "Model 3", 2022, 40000),
            new Vehicle("Renault", "Clio", 2012, 9000)
        );

        List<String> result = vehicles.stream()
            .filter(v -> v.getAny() > 2014)
            .map(v -> v.getMarca())
            .sorted()
            .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}

