package ACT11_6A;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UtilVendes gestor = new UtilVendes();

        gestor.carregaClients("clients", "c:\\temp\\clients.csv");
        gestor.carregaProductes("productes", "c:\\temp\\productes.csv");

        /*
        Client c = new Client(1, "Joan", "joan@gmail.com");
        Producte p1 = new Producte(1, "Televisor", 399.99, Categoria.ELECTRONICA);
        Producte p2 = new Producte(2, "Pantalons", 29.99, Categoria.ROBA);

        gestor.afegirClient(c);
        gestor.afegirProducte(p1);
        gestor.afegirProducte(p2); */

        /*
        gestor.desaClientAMySQL(c);
        gestor.desaProducteAMySQL(p1);
        gestor.desaProducteAMySQL(p2);
        */
        
        gestor.registrarVenda(1001, 101, Arrays.asList(201, 202), LocalDate.now());
        gestor.mostrarHistorialVendes();

        gestor.desaClientsACSV("clients_out.csv");
        gestor.desaProductesACSV("productes_out.csv");
    }
}
