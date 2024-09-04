package ACT7_0G;

/**
 *
 * @author winadmin
 */
// Clase concreta que representa un 'Cotxe'
class Cotxe extends Vehicle {
    private String model;

    // Constructor para la clase 'Cotxe'
    public Cotxe(int nrodes, String model) {
        super(nrodes);
        this.model = model;
    }

    // Implementaci�n del m�todo abstracto para mostrar detalles espec�ficos del autom�vil
    public void mostraDetalles() {
        System.out.println("Aix� �s un cotxe model " + model + ".");
    }
}
