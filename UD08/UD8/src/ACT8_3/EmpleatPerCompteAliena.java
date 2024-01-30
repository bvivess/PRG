package ACT8_3;

/** Subclasse d'empleat: Asalariat: té un salari fixe
 * 
 * @author winadmin
 */
// 
class EmpleatPerCompteAliena extends Empleat {
    
    // Constructor
    public EmpleatPerCompteAliena(String nom, String llinatge1, double souBase) {
        super(nom, llinatge1, souBase);
    }

    /** Implementació del mètode abstracte
     * 
     * @return double
     */
    @Override
    public double calculaSalari() {
        // El salario total es igual al salario base para empleados asalariados
        return souBase;
    }
}