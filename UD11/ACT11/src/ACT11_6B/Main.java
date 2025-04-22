package ACT11_6B;

import ACT11_6B.Utils.*;

public class Main {
    public static void main(String[] args) {
        GestorTaller gestorTaller = new GestorTaller();

        try {
            System.out.println("CLIENTS");
            gestorTaller.carregaClients("c:\\temp\\clients.csv");
            System.out.println("VEHICLES");
            gestorTaller.carregaVehicles("c:\\temp\\vehicles.csv");
            //gestorTaller.carregaReparacions("c:\\temp\\reparacions.csv");

            //gestorTaller.mostraClients();
            //gestorTaller.mostraVehicles();
            //gestorTaller.mostraReparacions();

            //gestorTaller.afegirVehicleARevisar("9999ZZZ");
            //gestorTaller.processarSeguentVehicle();

            //gestorTaller.modifica();

            //gestorTaller.desaClients("c:/temp/clients_out.csv");
            //gestorTaller.desaVehicles("c:/temp/vehicles_out.csv");
            //gestorTaller.desaReparacions("c:/temp/reparacions_out.csv");

        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }
}