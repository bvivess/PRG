package EX2_3;

// Classe abstracta Plat
import java.util.ArrayList;

public abstract class Plat implements UtilMenjar {
    protected String nom;
    protected ArrayList<Ingredient> ingredients;

    public Plat(String nom) {
        this.nom = nom;
        this.ingredients = new ArrayList<>();
    }

    public boolean afegeixIngredient(Ingredient i) {
        if (!(ingredients.contains(i)))
            return this.ingredients.add(i);
        return false;
    }
    
    public boolean eliminaIngredient(String nom) {
        return this.ingredients.removeIf(plat -> plat.nom.equals(nom));
    }

    @Override
    public double calculaPreu() {
        return UtilMenjar.PREU_PLAT;
    }

    @Override
    public boolean esPerVegetarians() {
        for (Ingredient i : this.ingredients)
            if (!(i.esVegetaria()))
                return false;
        return true;
    }

    @Override
    public boolean esPerCeliacs() {
        for (Ingredient i : this.ingredients)
            if (!(i.esCeliac()))
                return false;
        return true;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        String text = "Plat: " + nom;

        text += " Vegetarians: " + this.esPerVegetarians();
        text += " Celiacs: " + this.esPerCeliacs();
        text += " Preu: " + this.calculaPreu();

        return text;
    }
    
}
