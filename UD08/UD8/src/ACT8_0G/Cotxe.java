package ACT8_0G;

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

    // Implementación del método abstracto para mostrar detalles específicos del automóvil
    public void mostrarDetalles() {
        System.out.println("Això és un cotxe model " + model + ".");
    }
}
