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
            gestorVendes.desaClients("c:\\temp\\clients_out.csv");
            gestorVendes.desaProductes("c:\\temp\\productes_out.csv");
            
            // DESA VENDES
            gestorVendes.desaVendes("c:\\temp\\vendes_out.csv");

        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}
