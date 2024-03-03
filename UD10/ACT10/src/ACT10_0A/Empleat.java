package ACT10_0A;

public class Empleat {
    private String nom;
    private String llinatge;
    
    private static Empleat empleat;  // per assegurar que sols hi ha un empleat
    
    // Constructor en 'private'
    private Empleat(String nom, String llinatge) {  // per assegurar que no es crida des de fora
        this.nom = nom;
        this.llinatge = llinatge;
    }
    
    // Pseudo-constructor
    public static Empleat getEmpleat(String nom, String llinatge) {
        if (empleat == null)  // si no s'ha instanciat ?
            empleat = new Empleat(nom, llinatge);
        return empleat;
    }
    
    @Override
    public String toString() {
        return this.nom + " " + this.llinatge;
    }
    
}
