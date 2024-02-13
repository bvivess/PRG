package ACT9_3;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Creació de concessionaris i els vehicles
        ConcessionariAutos concessionariAutos = new ConcessionariAutos();
        concessionariAutos.setAutomobil(new Automobil("Renault", "Megane", 25000.0, "Turisme", 4, 500.0));
        concessionariAutos.setAutomobil(new Automobil("Honda", "Civic", 22000.0, "Turisme", 4, 450.0));
        concessionariAutos.setCamio(new Camio("Pegasus", "Brabus",15000,"Trucker", 5000.0));
        concessionariAutos.setCamio(new Camio("Ebro", "Santana",10000, "Truck", 500.0));

        ConcessionariMotos concessionariMotos = new ConcessionariMotos();
        concessionariMotos.setMotocicleta(new Motocicleta("Vespa", "Primavera", 2000.0, "Scotter", 125));
        concessionariMotos.setMotocicleta(new Motocicleta("Honda", "CBR", 15000.0, "Deportiva", 600));

        // Mostrar resultats
        System.out.println(concessionariAutos.toString());
        System.out.println(concessionariMotos.toString());
        System.out.println("Ingressos del Concesionari de Autos: " + concessionariAutos.calculaIngressos());
        System.out.println("Ingressos del Concesionari de Motos: " + concessionariMotos.calculaIngressos());
    }
}
