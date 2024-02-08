package ACT9_3;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Creación de vehículos
        Automobil auto1 = new Automobil("Toyota", "Camry", 25000.0, 4, 500.0);
        Automobil auto2 = new Automobil("Honda", "Civic", 22000.0, 4, 450.0);

        Motocicleta moto1 = new Motocicleta("Harley-Davidson", "Sportster", 12000.0, 1200, "Deportiva");
        Motocicleta moto2 = new Motocicleta("Honda", "CBR", 15000.0, 600, "Deportiva");

        // Creación de concesionarios
        ConcessionariAutos concessionariAutos = new ConcessionariAutos();
        concessionariAutos.agregarAutomovil(auto1);
        concessionariAutos.agregarAutomovil(auto2);

        ConcessionariMotos concessionariMotos = new ConcessionariMotos();
        concessionariMotos.agregarMotocicleta(moto1);
        concessionariMotos.agregarMotocicleta(moto2);

        // Cálculo de ingresos en cada concesionario
        double ingresosAutos = concessionariAutos.calculaIngressos();
        double ingresosMotos = concessionariMotos.calculaIngressos();

        // Mostrar resultados
        System.out.println("Ingresos del Concesionario de Autos: $" + ingresosAutos);
        System.out.println("Ingresos del Concesionario de Motos: $" + ingresosMotos);
    }
}
