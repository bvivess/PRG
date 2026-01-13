package ACT6_0A;

/**
 * Modela una persona tipus
 * @author T.Vives
 */

public class Persona {
    // Atributs
    private String nom;
    private String llinatge1;
    private String llinatge2;
    private int edat;
    
    // Constructors
    public Persona(String nom, String llinatge1, String llinatge2, int edat) {
        setNom(nom);  // this.nom = nom;
        setLlinatge1(llinatge1);  // this.llinatge1 = llinatge1;
        setLlinatge2(llinatge2);  // this.llinatge2 = llinatge2;
        setEdat(edat);  // this.edat = edat;
    }
    
    // Mètodes específics
    /**
     * Mostra els atributs de la classe
     * @return String amb les dades concatenades
    */
    public void mostraPersona() {
        System.out.println("Nom: " + getNom() + " " + llinatge1 + " " + llinatge2 + "Edat: " + getEdat());
    }
    
    // Getters i Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatge1() {
        return llinatge1;
    }

    public void setLlinatge1(String llinatge1) {
        this.llinatge1 = llinatge1;
    }

    public String getLlinatge2() {
        return llinatge2;
    }

    public void setLlinatge2(String llinatge2) {
        this.llinatge2 = llinatge2;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

}