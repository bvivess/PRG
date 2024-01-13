package ACT8_1;

/**
 *
 * @author winadmin
 */
// Clase concreta EmpleadoAsalariado
class EmpleatPerCompteAliena extends Empleat {
    // Constructor
    public EmpleatPerCompteAliena(String nom, String llinatge1, double souBase) {
        super(nom, llinatge1, souBase);
    }

    // Implementación del método abstracto
    @Override
    public double calcularSalari() {
        // El salario total es igual al salario base para empleados asalariados
        return souBase;
    }
}