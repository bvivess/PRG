package ACT8_3;

/**
 *
 * @author winadmin
 */
// Clase concreta EmpleadoAsalariado
class EmpleatPerCompteAliena extends Empleat {
    // Constructor
    public EmpleatPerCompteAliena(String nom, String llinatge1, double salarioBase) {
        super(nom, llinatge1, salarioBase);
    }

    // Implementación del método abstracto
    @Override
    public double calcularSalari() {
        // El salario total es igual al salario base para empleados asalariados
        return salarioBase;
    }
}