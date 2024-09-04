package ACT7_3;

/** Subclasse d'empleat: Asalariat: t� un salari fixe
 * 
 * @author winadmin
 */
// 
class EmpleatAssalariat extends Empleat {
    
    // Constructor
    public EmpleatAssalariat(String nom, String llinatge1, double souBase) {
        super(nom, llinatge1, souBase);
    }

    /** Implementaci� del m�tode abstracte
     * 
     * @return double
     */
    @Override
    public double calculaSalari() {
        // El salario total es igual al salario base para empleados asalariados
        return super.souBase;
    }
}