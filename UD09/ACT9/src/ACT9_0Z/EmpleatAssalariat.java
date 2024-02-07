package ACT9_0Z;

/** Subclasse d'empleat: Asalariat: té un salari fixe
 * 
 * @author winadmin
 */
// 
class EmpleatAssalariat extends Empleat {
    
    // Constructor
    public EmpleatAssalariat(String nom, String llinatge1, double souBase) {
        super(nom, llinatge1, souBase);
    }
    
    @Override
    public double calculaSalari() {
        // El salario total es igual al salario base para empleados asalariados
        return super.getSouBase();
    }
}