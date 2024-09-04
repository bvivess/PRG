package ACT7_0G;

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
 
    // M�tode abstracte que ha de ser implementat en les 'subclasses'
    public abstract void mostraDetalles();
    
    // M�tode concret que proporciona informaci� general del 'Veh�cle' 
    public void mostraInformacionGeneral() {
        System.out.println("Aix� �s un veh�cle amb " + nrodes + " rodes.");
    }
}

