package ACT8_2;

/**
 *
 * @author winadmin
 */
// Classe abstracta Empleat
abstract class Empleat {
    // Atributos
    protected String nom;
    protected String llinatge1;
    protected double souBase;

    // Constructor
    public Empleat(String nom, String llinatge1, double souBase) {
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.souBase = souBase;  // salari mensual o per hora treballada
    }

    // Método abstracto para calcular salario
    public abstract double calcularSalari();

    // Método para mostrar detalles del empleado
    @Override
    public String toString() {
        return "Nombre: " + nom + " " + llinatge1 + ", Sou Base: " + souBase + ", Salari " + calcularSalari();
    }

    @Override
    public boolean equals(Object obj) {
        Empleat empleat = (Empleat) obj;
        
        return (this.nom.equals(empleat.nom)) && (this.llinatge1.equals(empleat.llinatge1));
    }
    
    

}