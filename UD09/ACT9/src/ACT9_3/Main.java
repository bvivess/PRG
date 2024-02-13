package ACT9_3;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Creació de vehícles
        Automobil auto1 = new Automobil("Renault", "Megane", 25000.0, "Turisme", 4, 500.0);
        Automobil auto2 = new Automobil("Honda", "Civic", 22000.0, "Turisme", 4, 450.0);
        Camio camio1 = new Camio("Pegasus", "Brabus",15000,"Trucker", 5000.0);
        Camio camio2 = new Camio("Ebro", "Santana",10000, "Truck", 500.0);

        Motocicleta moto1 = new Motocicleta("Vespa", "Primavera", 2000.0, 125, "Scotter");
        Motocicleta moto2 = new Motocicleta("Honda", "CBR", 15000.0, 600, "Deportiva");

        // Creació de concessionaris
        ConcessionariAutos concessionariAutos = new ConcessionariAutos();
        concessionariAutos.setAutomovil(auto1);
        concessionariAutos.setAutomovil(auto2);
        concessionariAutos.setCamio(camio1);
        concessionariAutos.setCamio(camio2);

        ConcessionariMotos concessionariMotos = new ConcessionariMotos();
        concessionariMotos.setMotocicleta(moto1);
        concessionariMotos.setMotocicleta(moto2);

        // Mostrar resultados
        System.out.println(concessionariAutos.toString());
        System.out.println(concessionariMotos.toString());
        System.out.println("Ingressos del Concesionari de Autos: " + concessionariAutos.calculaIngressos());
        System.out.println("Ingressos del Concesionari de Motos: " + concessionariMotos.calculaIngressos());
    }
}
