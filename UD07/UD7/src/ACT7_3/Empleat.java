package ACT7_3;

/**
 *
 * @author winadmin
 */
// Classe abstracta Empleat
abstract class Empleat {
    // Atributos
    protected String nom;
    protected String llinatge;
    protected double souBase;  // per mes (en 'EmpleatPerCompteAliena') o per hora treballada (en 'EmpleatPerComptePropia')

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

    /** M�tode concret per mostrar detalls de l'empleat
     * 
     * @return String 
     */
    @Override
    public String toString() {
        return "Nombre: " + nom + " " + llinatge + ", Sou Base: " + souBase + ", Salari " + calculaSalari();
    }

    @Override
    public boolean equals(Object obj) {
        Empleat empleat = (Empleat) obj;
        
        return (this.nom.equals(empleat.nom)) && (this.llinatge.equals(empleat.llinatge));
    }
    
    

}