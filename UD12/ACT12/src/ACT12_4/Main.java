package ACT12_4;

import ACT12_4.Utils.Gestor;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        
        try {
            // CÀRREGA CLIENTS, PRODUCTES i VENDES
            System.out.println("CLIENTS");
            gestor.carregaClients("c:\\temp\\clients.csv");
            System.out.println("PRODUCTES");
            gestor.carregaProductes("c:\\temp\\productes.csv");
            System.out.println("VENDES");
            gestor.carregaVendes("c:\\temp\\vendes.csv");
            
            // MODIFICA DADES
            gestor.modifica();
            
            // DESA CLIENTS, PRODUCTES i VENDES
            gestor.desaClients("c:\\temp\\clients_out.csv");
            gestor.desaProductes("c:\\temp\\productes_out.csv");
            gestor.desaVendes("c:\\temp\\vendes_out.csv");

        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}
