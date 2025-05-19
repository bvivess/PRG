package EX_3_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main3 {

    public static void main(String[] args) {

        // Llista de vehicles
        List<Vehicle> vehicles = Arrays.asList(
            new Vehicle("1234-HJK", "Toyota",     "Corolla", 2010, 12000),
            new Vehicle("1230-BCN", "Toyota",     "Yaris",   2010, 12200),
            new Vehicle("5678-KLM", "Volkswagen", "Golf",    2018, 18000),
            new Vehicle("5669-HYM", "Volkswagen", "Polo",    2020, 21000),
            new Vehicle("9012-NPR", "Seat",       "Ibiza",   2015, 10000),
            new Vehicle("3456-STU", "Tesla",      "Model 3", 2022, 40000),
            new Vehicle("7890-VWX", "Renault",    "Clio",    2012,  9000)
        );

        // Lambda que incrementa el preu del vehicle un 10%, modificant l'objecte
        Function<Vehicle, Vehicle> incrementaPreu1 = v -> {  
                                                           v.setPreu((v.getPreu() * 1.10));
                                                           return v;
                                                         };
        // Lambda que incrementa el preu del vehicle un 10%, modificant l'objecte
        BiFunction<Vehicle, Double, Vehicle> incrementaPreu2 = (v, factor) -> {
                                                                               v.setPreu((int) (v.getPreu() * factor));
                                                                               return v;
                                                                             };

        // Aplica la lambda a cada vehicle i imprimeix el resultat
        vehicles.stream()
                .map(incrementaPreu1)
                .forEach(v -> System.out.println(v));
        
        // Aplica la lambda a cada vehicle i imprimeix el resultat
        vehicles.stream()
                .map(v -> incrementaPreu2.apply(v, 1.10))
                .forEach(v -> System.out.println(v));
    }
}

