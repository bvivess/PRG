package EX_2_3.Consumicions;

import java.util.ArrayList;

public class Carta {
    private ArrayList<Menjar> menjars;
    private ArrayList<Beguda> beures;
    
    public Carta() {
        this.menjars = new ArrayList<>();
        this.beures = new ArrayList<>();
    }
    
    public boolean afegeixConsumicio(Consumicio c) {
        if (c instanceof Menjar)
            return afegeixMenjar((Menjar) c);
        else if (c instanceof Beguda)
            return afegeixBeure((Beguda) c);
        return false;
    }
    
    private boolean afegeixMenjar(Menjar m) {
        if (!(this.menjars.contains(m))) {
            this.menjars.add(m);
            return true;
        } else
            return false;
    }
    
    private boolean afegeixBeure(Beguda b) {
        if (!(this.beures.contains(b))) {
            this.beures.add(b);
            return true;
        } else
            return false;
    }
    
    public boolean eliminaConsumicio(String n) {
        if (!eliminaMenjar(n)) {
            return eliminaBeure(n);
        } else
            return true;
    }

    private boolean eliminaMenjar(String n) {
        /*
        int i = this.menjars.indexOf(new Menjar(n) {});        
        if (i!=-1) {
            this.menjars.remove(i);
            return true;
        } else
            return false;
        */
        for (int i = 0; i < this.menjars.size(); i++) {
            if (this.menjars.get(i).getNom().equals(n)) {
                this.menjars.remove(i);
                return true;
            }
        }
        return false;
    }
    
    private boolean eliminaBeure(String n) {
        /*
        int i = this.beures.indexOf(new Beguda(n) { @Override
                                                   public boolean esEstimulant() {
                                                       return false; 
                                                   }
                                                 });
        if (i!=-1) {
            this.beures.remove(i);
            return true;
        } else
            return false;
        */
        for (int i = 0; i < beures.size(); i++) {
            if (this.beures.get(i).getNom().equals(n)) {
                this.beures.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Carta{" + "\nmenjars=" + menjars.toString() + ",\nbeures=" + beures.toString() + "}";
    }
    
    
}
