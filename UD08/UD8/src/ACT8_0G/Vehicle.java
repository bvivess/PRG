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
 
    // Métode abstracte que ha de ser implementat en les 'subclasses'
    public abstract void mostraDetalles();
    
    // Mètode concret que proporciona informació general del 'Vehícle' 
    public void mostraInformacionGeneral() {
        System.out.println("Això és un vehícle amb " + nrodes + " rodes.");
    }
}

