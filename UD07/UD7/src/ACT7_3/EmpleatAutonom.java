package ACT7_3;

/** Subclasse d'empleat: Compte pr�pia
 *
 * @author winadmin
 */
class EmpleatAutonom extends Empleat {
    private int horesTreballades;

    // Constructor
    public EmpleatAutonom(String nom, String llinatge1, double souPerHores, int horesTreballades) {
        super(nom, llinatge1, souPerHores);
        this.horesTreballades = horesTreballades;
    }

    /** Implementaci� del m�tode abstracte
     * 
     * @return double
     */
    @Override
    public double calculaSalari() {
        // El salario total para empleados por hora depende de las horas trabajadas
        return super.souBase * this.horesTreballades;
    }

    //@Override
    //public String toString() {
    //    return super.toString() + " Hores Treballades= " + horesTreballades;
    //}
    
    
}

