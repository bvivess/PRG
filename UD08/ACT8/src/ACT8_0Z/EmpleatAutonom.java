package ACT8_0Z;

/** Subclasse d'empleat: Compte pròpia
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

    public int getHoresTreballades() {
        return horesTreballades;
    }
    
    @Override
    public double calculaSalari() {
        // El salario total para empleados por hora depende de las horas trabajadas
        return super.getSouBase() * this.getHoresTreballades();
    }
}

