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

        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}
