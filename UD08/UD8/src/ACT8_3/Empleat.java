package ACT8_3;

/**
 *
 * @author winadmin
 */
// Classe abstracta Empleat
abstract class Empleat {
    // Atributos
    protected String nom;
    protected String llinatge1;
    protected double salarioBase;

    // Constructor
    public Empleat(String nom, String llinatge1, double salarioBase) {
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.salarioBase = salarioBase;
    }

    // Método abstracto para calcular salario
    public abstract double calcularSalari();

    // Método para mostrar detalles del empleado
    @Override
    public String toString() {
        return "Nombre: " + nom + " " + llinatge1 + ", Sou Base: " + salarioBase + ", Salari " + calcularSalari();
    }

    @Override
    public boolean equals(Object obj) {
        Empleat empleat = (Empleat) obj;
        
        if ((this.nom.equals(empleat.nom)) && (this.llinatge1.equals(empleat.llinatge1)))
            return true;
        else
            return false;
    }
    
    

}