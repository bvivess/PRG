package ACT8_0G;

/**
 *
 * @author winadmin
 */
// Classe abstracta que representa un 'Vehicle'
abstract class Vehicle {
    int nrodes = 4;
    
    // Constructor

    public Vehicle(int nrodes) {
        this.nrodes = nrodes;
    }
    
    
    // Mètode concret que proporciona informació general del 'Vehícle' 
    public void mostrarInformacionGeneral() {
        System.out.println("Això és un vehícle amb " + nrodes + " rodes.");
    }

    // Método abstracto que debe ser implementado por las clases concretas
    public abstract void mostrarDetalles();
}

