package ACT9_3;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Creació de vehícles
        Automobil auto1 = new Automobil("Toyota", "Camry", 25000.0, 4, 500.0);
        Automobil auto2 = new Automobil("Honda", "Civic", 22000.0, 4, 450.0);

        Motocicleta moto1 = new Motocicleta("Vespa", "Primavera", 2000.0, 125, "Scotter");
        Motocicleta moto2 = new Motocicleta("Honda", "CBR", 15000.0, 600, "Deportiva");

        // Creació de concessionaris
        ConcessionariAutos concessionariAutos = new ConcessionariAutos();
        concessionariAutos.agregarAutomovil(auto1);
        concessionariAutos.agregarAutomovil(auto2);

        ConcessionariMotos concessionariMotos = new ConcessionariMotos();
        concessionariMotos.agregarMotocicleta(moto1);
        concessionariMotos.agregarMotocicleta(moto2);

        // Mostrar resultados
        System.out.println(concessionariAutos);
        System.out.println(concessionariMotos);
        System.out.println("Ingressos del Concesionari de Autos: " + concessionariAutos.calculaIngressos());
        System.out.println("Ingressos del Concesionari de Motos: " + concessionariMotos.calculaIngressos());
    }
}
