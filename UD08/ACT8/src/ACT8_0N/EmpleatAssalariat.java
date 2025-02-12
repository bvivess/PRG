package ACT8_0N;

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
    
    @Override
    public double calculaSalari() {
        // El salari �s igual al salari base per a empleats asalariars
        return super.getSouBase();
    }
}