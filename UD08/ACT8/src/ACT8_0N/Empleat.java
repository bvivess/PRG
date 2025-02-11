package ACT8_0N;

/**
 *
 * @author winadmin
 */
// Classe abstracta Empleat
abstract class Empleat {
    // Atributos
    private String nom;
    private String llinatge;
    private double souBase;  // per mes (en 'EmpleatPerCompteAliena') o per hora treballada (en 'EmpleatPerComptePropia')

    // Constructor
    public Empleat(String nom, String llinatge, double souBase) {
        this.nom = nom;
        this.llinatge = llinatge;
        this.souBase = souBase;  // salari mensual o per hora treballada
    }

    /** M�tode abstracte per calcular salari 
     *
     * @return double
     */
    public abstract double calculaSalari();
    
    public double getSouBase() {
        return souBase;
    }
    
    /** M�tode concret per mostrar detalls de l'empleat
     * 
     * @return String 
     */
    @Override
    public String toString() {
        return "Nombre: " + nom + " " + llinatge + ", Sou Base: " + souBase;
    }

    @Override
    public boolean equals(Object obj) {
        Empleat empleat = (Empleat) obj;
        
        return (this.nom.equals(empleat.nom)) && (this.llinatge.equals(empleat.llinatge));
    }
    
    

}