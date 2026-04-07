package EX_3_1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            // Crea un objecte 'Restaurant'
            Restaurant r = new Restaurant();

            // Registra les Comandes
            System.out.println("=== REGISTRE COMANDES ===");
            System.out.println(r.registraComanda(1, "Anna", 1, LocalDateTime.now(), Arrays.asList( new Plat("Pizza Margarita") )) ? "Comanda OK" : "Comanda KO");
            System.out.println(r.registraComanda(2, "Joan", 2, LocalDateTime.now(), Arrays.asList( new Plat("Pasta") )) ? "Comanda OK" : "Comanda KO");
            System.out.println(r.registraComanda(3, "Maria", 1, LocalDateTime.now(), Arrays.asList( new Plat("Amanida") )) ? "Comanda OK" : "Comanda KO");
            //System.out.println(r.registraComanda(4, "Error", 5, LocalDateTime.now(), Arrays.asList( new Plat("Duplicat") )) ? "Comanda OK" : "Comanda KO");
            // CORRECCIO: la linia anterior està comentada perquè falla l''offer'
            // Mostra les comandes per estat
            System.out.println("=== COMANDES PER ESTAT ===");
            r.mostraComandesPerEstat();

            // Treballa la 'Comanda' amb id=1
            System.out.println("=== EN PREPARACIÓ ===");
            System.out.println(r.iniciaPreparacio() ? "En preparació OK" : "En preparació KO");

            System.out.println("=== SERVIDA ===");
            System.out.println(r.serveixComanda(1) ? "Servida OK" : "Servida KO");

            System.out.println("=== COBRAR ===");
            System.out.println(r.cobraComanda(1) ? "Cobrada OK" : "Cobrada KO");

            System.out.println("=== COMANDES PER ESTAT ===");
            r.mostraComandesPerEstat();

            // Utilitza els 'cerca*'
            System.out.println("=== MOSTRA COMANDA ===");
            System.out.println(r.cercaComanda(2).toString());

            System.out.println("=== MOSTRA COMANDES PER ESTAT ===");
            System.out.println("COMANDES 'PENDENT': " + r.cercaComandesPerEstat(EstatComanda.PENDENT).toString());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
    }
}
