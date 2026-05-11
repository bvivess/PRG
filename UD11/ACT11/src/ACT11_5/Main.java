package ACT11_5;

import ACT11_5.Utils.GestorVendes;

public class Main {
    private static final String MYSQL_CON  = "c:\\temp\\mysql.con";
    private static final String CSV_CLIENTS_PATH   = "c:\\temp\\clients.csv";
    private static final String CSV_PRODUCTES_PATH   = "c:\\temp\\productes.csv";
    private static final String CSV_VENDES_PATH   = "c:\\temp\\vedes.csv";
    private static final String LOG_PATH   = "c:\\temp\\arxiu.log";
    
    public static void main(String[] args) {
        GestorVendes gestorVendes = new GestorVendes();
        
        try {
            // CÀRREGA CLIENTS, PRODUCTES i VENDES
            System.out.println("CLIENTS");
            gestorVendes.carregaClients(CSV_CLIENTS_PATH);
            
            System.out.println("PRODUCTES");
            gestorVendes.carregaProductes(CSV_PRODUCTES_PATH);
            
            System.out.println("VENDES");
            gestorVendes.carregaVendes(CSV_VENDES_PATH );
            
            // MODIFICA DADES
            gestorVendes.modifica();
            
            // DESA CLIENTS, PRODUCTES i VENDES
            gestorVendes.desaClients("c:\\temp\\clients_out.csv");
            gestorVendes.desaProductes("c:\\temp\\productes_out.csv");
            gestorVendes.desaVendes("c:\\temp\\vendes_out.csv");

        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}
