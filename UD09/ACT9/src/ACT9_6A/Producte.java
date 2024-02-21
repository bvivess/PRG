package ACT9_6A;

/**
 *
 * @author winadmin
 */
public abstract class Producte {
    private String nom;
    private double preu;
    private double consumEnergetic;
    private int garantiaMesos;
    private int midaPantalla;

    public Producte(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla) {
        this.nom = nom;
        this.preu = preu;
        this.consumEnergetic = consumEnergetic;
        this.garantiaMesos = garantiaMesos;
        this.midaPantalla = midaPantalla;
    }
    
    // Mètode abstracte que cal implementar a les subclasses
    public abstract double calculaDescompte();
    
    // Getters i setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public double getConsumEnergetic() {
        return consumEnergetic;
    }

    public void setConsumEnergetic(double consumEnergetic) {
        this.consumEnergetic = consumEnergetic;
    }

    public int getGarantiaMesos() {
        return garantiaMesos;
    }

    public void setGarantiaMesos(int garantiaMesos) {
        this.garantiaMesos = garantiaMesos;
    }

    @Override
    public String toString() {
        return "ProducteElectronic {" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", consumEnergetic=" + consumEnergetic +
                ", garantiaMesos=" + garantiaMesos +
                '}';
    }
}