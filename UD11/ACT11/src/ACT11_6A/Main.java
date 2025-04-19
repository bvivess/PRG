package ACT11_6A;

import ACT11_6A.Utils.GestorVendes;

public class Main {
    public static void main(String[] args) {
        GestorVendes gestorVendes = new GestorVendes();
        
        try {
            // CLIENTS i PRODUCTES
            gestorVendes.carregaClients("c:\\temp\\clients.csv");
            gestorVendes.carregaProductes("c:\\temp\\productes.csv");
            
            // VENDES
            gestorVendes.carregaVendes("c:\\temp\\vendes.csv");

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
