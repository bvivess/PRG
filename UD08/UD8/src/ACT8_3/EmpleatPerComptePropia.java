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
    private int horasTrabajadas;

    // Constructor
    public EmpleatPerComptePropia(String nom, String llinatge1, double salarioBase, int horasTrabajadas) {
        super(nom, llinatge1, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    // Implementación del método abstracto
    @Override
    public double calcularSalari() {
        // El salario total para empleados por hora depende de las horas trabajadas
        return salarioBase * horasTrabajadas;
    }
}

