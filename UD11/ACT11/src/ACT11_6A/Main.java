package ACT11_6A;

import ACT11_6A.Utils.GestorVendes;

public class Main {
    public static void main(String[] args) {
        GestorVendes gestorVendes = new GestorVendes();
        
        try {
            // CÀRREGA CLIENTS i PRODUCTES
            gestorVendes.carregaClients("c:\\temp\\clients.csv");
            gestorVendes.carregaProductes("c:\\temp\\productes.csv");
            
            // CÀRREGA VENDES
            gestorVendes.carregaVendes("c:\\temp\\vendes.csv");
            
            // DESA CLIENTS i PRODUCTES
            gestorVendes.desaClients();
            gestorVendes.desaProductes();
            
            // DESA VENDES
            gestorVendes.desaClients();

        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}
