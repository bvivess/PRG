package EX_UD09_II_B;

public class TipusIva {
    protected String nom;
    protected double tantPerCent;

    public TipusIva(String nom, double tantPerCent) {
        this.nom = nom;
        this.tantPerCent = tantPerCent;
    }

    @Override
    public String toString() {
        return "IVA: " + this.nom + 
               " " + this.tantPerCent +"%";
    }
 
}