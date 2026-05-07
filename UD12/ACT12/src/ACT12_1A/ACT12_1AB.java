package ACT12_1A;


import java.util.*;
import java.util.stream.*;

public class ACT12_1AB {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Juan", "Jordi", "Joan", "Pere", "Maria", "Joaquim","Jaume", "Judith");

        System.out.println("Llista: " + noms);
        noms.stream()  // /"Juan", "Jordi", "Joan", "Pere", "Maria", "Joaquim","Jaume", "Judith"/
            .filter( a ->  a.startsWith("J") )  // /"Juan", "Jordi", "Joan", "Joaquim","Jaume", "Judith"/
            .skip(2)  // /"Joan", "Joaquim","Jaume", "Judith"/
            .limit(3)
            .forEach(n -> System.out.println(n));
    }
}
