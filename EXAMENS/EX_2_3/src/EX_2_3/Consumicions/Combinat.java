package EX_2_3.Consumicions;

import java.util.ArrayList;

public class Combinat extends Beguda {
    private ArrayList<Beguda> ingredients;

    public Combinat(String nom, double preu) {
        super(nom, preu);
        this.ingredients = new ArrayList<>();
    }
    
    public boolean afegeixBeure(Beguda b) {
        if (!(this.ingredients.contains(b))) {
            this.ingredients.add(b);
            return true;
        } else
            return false;
    }
    
    public boolean eliminaBeure(String n) {
        /*
        int i = this.ingredients.indexOf(new Beguda(n) { @Override
                                                         public boolean esEstimulant() {
                                                            return false; 
                                                         }
                                                       });
        if (i!=-1) {
            this.ingredients.remove(i);
            return true;
        } else
            return false;
        */
        for (int i = 0; i < this.ingredients.size(); i++) {
            if (this.ingredients.get(i).getNom().equals(n)) {
                this.ingredients.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean esEstimulant() {
        for (Beguda b : this.ingredients)
            if (b.esEstimulant())
                return true;
        return false;
    }

    public ArrayList<Beguda> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return super.toString() + " ingredients=" + ingredients;
    }

}