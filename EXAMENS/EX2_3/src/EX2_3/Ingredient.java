package EX2_3;

// Classe Ingredient

import java.util.Objects;

public class Ingredient {
    protected String nom;
    protected boolean esVegetaria;
    protected boolean esCeliac;

    public Ingredient(String nom, boolean esVegetaria, boolean esCeliac) {
        this.nom = nom;
        this.esVegetaria = esVegetaria;
        this.esCeliac = esCeliac;
    }
    
    public boolean esVegetaria() {
        return esVegetaria;
    }
    
    public boolean esCeliac() {
        return esCeliac;
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
        
        final Ingredient i = (Ingredient) obj;
        return this.nom.equals(i.nom);
    }
    
}
