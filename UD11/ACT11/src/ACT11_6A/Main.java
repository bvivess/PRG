package ACT11_6A;

import ACT11_6A.Classes.*;
import ACT11_6A.Utils.UtilVendes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        List<Producte> productes = new ArrayList<>();
        Map<Integer,Venda> vendes = new HashMap<>();

        UtilVendes gestorVendes = new UtilVendes();
        
        try {

            gestorVendes.carregaClients(clients, "c:\\temp\\clients.csv");
            gestorVendes.carregaProductes(productes, "c:\\temp\\productes.csv");
            
            gestorVendes.carregaVendes(vendes, "c:\\temp\\vendes.csv");

            /*
            Client c = new Client(1, "Joan", "joan@gmail.com");
            Producte p1 = new Producte(1, "Televisor", 399.99, Categoria.ELECTRONICA);
            Producte p2 = new Producte(2, "Pantalons", 29.99, Categoria.ROBA);


            /*
            gestorVendes.registrarVenda(1001, 101, Arrays.asList(201, 202), LocalDate.now());
            gestorVendes.mostrarHistorialVendes();

            gestorVendes.desaClientsACSV("clients_out.csv");
            gestorVendes.desaProductesACSV("productes_out.csv");
            */
        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}
