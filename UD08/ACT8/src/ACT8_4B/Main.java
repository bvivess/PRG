package ACT8_4B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Versió 1
        // Creació de concessionaris i vehicles
        ConcessionariAutos concessionariAutos = new ConcessionariAutos();
        creaConcessionariAutos(concessionariAutos);

        ConcessionariMotos concessionariMotos = new ConcessionariMotos();
        creaConcessionariMotos(concessionariMotos);

        // Mostrar resultats
        System.out.println(concessionariAutos.toString());
        System.out.println(concessionariMotos.toString());
        System.out.println("Ingressos del Concesionari de Autos: " + concessionariAutos.calculaIngressos());
        System.out.println("Ingressos del Concesionari de Motos: " + concessionariMotos.calculaIngressos());
        
        // -----------------------------------------
        // Versió 2
        // Creació de concessionari 
        ArrayList< ArrayList<Vehicle> > concesionari = new ArrayList<>();
        
        ArrayList<Vehicle> motos = new ArrayList<>();
        motos.add(new Motocicleta("Vespa", "Primavera", 2000.0, "Scotter", 125));
        motos.add(new Motocicleta("Honda", "CBR", 15000.0, "Deportiva", 600));
        
        ArrayList<Vehicle> autos = new ArrayList<>();
        autos.add(new Automobil("Renault", "Megane", 25000.0, "Turisme", 4, 500.0));
        
        ArrayList<Vehicle> camions = new ArrayList<>();
        camions.add(new Camio("Ebro", "Santana", 10000, "Truck", 500.0));
        
        
        concesionari.add(motos);
        concesionari.add(autos);
        concesionari.add(camions);
    }
    
    private static void creaConcessionariAutos(ConcessionariAutos concessionariAutos) {
        concessionariAutos.setVehicle(new Automobil("Renault", "Megane", 25000.0, "Turisme", 4, 500.0));
        concessionariAutos.setVehicle(new Automobil("Honda", "Civic", 22000.0, "Turisme", 4, 450.0));
        concessionariAutos.setVehicle(new Camio("Pegasus", "Brabus", 15000.0,"Trucker", 5000.0));
        concessionariAutos.setVehicle(new Camio("Ebro", "Santana", 10000.0, "Truck", 500.0));
    }
    
    private static void creaConcessionariMotos(ConcessionariMotos concessionariMotos) {
        concessionariMotos.setMotocicleta(new Motocicleta("Labretta", "Model D", 3300.0, "Scotter", 125));
        concessionariMotos.setMotocicleta(new Motocicleta("Vespa", "Primavera", 2000.0, "Scotter", 125));
        concessionariMotos.setMotocicleta(new Motocicleta("Honda", "CBR", 15000.0, "Deportiva", 600));
    }

}
