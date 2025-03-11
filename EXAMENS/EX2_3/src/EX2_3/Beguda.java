package EX2_3;

// Classe abstracta Beguda
public abstract class Beguda implements UtilBeure {
    protected String nom;

    public Beguda(String nom) {
        this.nom = nom;
    }

    @Override
    public double calculaPreu() {
        return UtilBeure.PREU_BEGUDA;
    }

    public String getNom() {
        return nom;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Beguda b = (Beguda) obj;
        return this.nom.equals(b.nom);
    }
    
    
}
