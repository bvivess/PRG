public class Caracteristica {
    private String nom;
    private double preuCaracteristica;
    private boolean esPremium;
    
    public Caracteristica(String nom, double preuCaracteristica, boolean esPremium) {
        this.nom = nom;
        this.esPremium = esPremium;
        this.setPreuCaracteristica(preuCaracteristica);
    }

    public String getNom() { 
        return nom; 
    }
    
    public double getPreuCaracteristica() {
        return preuCaracteristica;
    }

    public void setPreuCaracteristica(double preuCaracteristica) {
        if (preuCaracteristica>=0)
            this.preuCaracteristica = preuCaracteristica;
        else
            throw new IllegalArgumentException("Preu Caracterítica incorrecte");
    }
 
    public boolean esPremium() {
        return esPremium; 
    }

    // 2 'Caracteristica' són iguals si ho són per 'nom'
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Caracteristica c = (Caracteristica) obj;
        return this.nom.equals(c.nom);
    }

    @Override
    public String toString() {
        return "Característica{" + "nom=" + nom + ", preu=" + preuCaracteristica + ", esPremium=" + esPremium + '}';
    }
    
}