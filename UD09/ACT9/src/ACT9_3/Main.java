package ACT9_3;

/**
 *
 * @author winadmin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
-------------------------------------
// Clase abstracta para Vehículos
public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private double precio;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    // Getters y setters

    public abstract double calcularImpuesto();
}

// Clase para Automóviles
public class Automovil extends Vehiculo {
    private int numPuertas;
    private double capacidadMaletero;

    public Automovil(String marca, String modelo, double precio, int numPuertas, double capacidadMaletero) {
        super(marca, modelo, precio);
        this.numPuertas = numPuertas;
        this.capacidadMaletero = capacidadMaletero;
    }

    @Override
    public double calcularImpuesto() {
        return 0.1 * getPrecio(); // Impuesto del 10%
    }
}

// Clase para Motocicletas
public class Motocicleta extends Vehiculo {
    private int cilindrada;
    private String tipo;

    public Motocicleta(String marca, String modelo, double precio, int cilindrada, String tipo) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    @Override
    public double calcularImpuesto() {
        return 0.05 * getPrecio(); // Impuesto del 5%
    }
}
------------------------------------------
import java.util.ArrayList;

// Interfaz para Concesionarios
public interface Concesionario {
    double calcularIngresos();
}

// Clase para Concesionario de Automóviles
public class ConcesionarioAutos implements Concesionario {
    private ArrayList<Automovil> autos = new ArrayList<>();

    public void agregarAutomovil(Automovil auto) {
        autos.add(auto);
    }

    @Override
    public double calcularIngresos() {
        double ingresos = 0;
        for (Automovil auto : autos) {
            ingresos += auto.getPrecio() + auto.calcularImpuesto();
        }
        return ingresos;
    }
}

// Clase para Concesionario de Motocicletas
public class ConcesionarioMotos implements Concesionario {
    private ArrayList<Motocicleta> motos = new ArrayList<>();

    public void agregarMotocicleta(Motocicleta moto) {
        motos.add(moto);
    }

    @Override
    public double calcularIngresos() {
        double ingresos = 0;
        for (Motocicleta moto : motos) {
            ingresos += moto.getPrecio() + moto.calcularImpuesto();
        }
        return ingresos;
    }
}
----------------------------------

public class Main {
    public static void main(String[] args) {
        // Creación de vehículos
        Automovil auto1 = new Automovil("Toyota", "Camry", 25000.0, 4, 500.0);
        Automovil auto2 = new Automovil("Honda", "Civic", 22000.0, 4, 450.0);

        Motocicleta moto1 = new Motocicleta("Harley-Davidson", "Sportster", 12000.0, 1200, "Deportiva");
        Motocicleta moto2 = new Motocicleta("Honda", "CBR", 15000.0, 600, "Deportiva");

        // Creación de concesionarios
        ConcesionarioAutos concesionarioAutos = new ConcesionarioAutos();
        concesionarioAutos.agregarAutomovil(auto1);
        concesionarioAutos.agregarAutomovil(auto2);

        ConcesionarioMotos concesionarioMotos = new ConcesionarioMotos();
        concesionarioMotos.agregarMotocicleta(moto1);
        concesionarioMotos.agregarMotocicleta(moto2);

        // Cálculo de ingresos en cada concesionario
        double ingresosAutos = concesionarioAutos.calcularIngresos();
        double ingresosMotos = concesionarioMotos.calcularIngresos();

        // Mostrar resultados
        System.out.println("Ingresos del Concesionario de Autos: $" + ingresosAutos);
        System.out.println("Ingresos del Concesionario de Motos: $" + ingresosMotos);
    }
}
