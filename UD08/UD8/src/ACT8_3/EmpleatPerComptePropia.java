/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package ACT8_3;

/**
 *
 * @author winadmin
 */
// Clase concreta EmpleadoPorHora
class EmpleatPerComptePropia extends Empleat {
    // Atributo adicional
    private int horesTreballades;

    // Constructor
    public EmpleatPerComptePropia(String nom, String llinatge1, double souPerHores, int horesTreballades) {
        super(nom, llinatge1, souPerHores);
        this.horesTreballades = horesTreballades;
    }

    // Implementación del método abstracto
    @Override
    public double calcularSalari() {
        // El salario total para empleados por hora depende de las horas trabajadas
        return souBase * horesTreballades;
    }
}

