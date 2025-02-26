package ACT8_6B;

/**
 *
 * @author winadmin
 */
public class Portatil extends Electronic {
    public Portatil(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla, String processador, int ram, int hdd) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla, processador, ram, hdd);
    }

    @Override
    public double calculaDescompte() {
        return (getConsumEnergetic() > 20) ? 0.15 * getPreuBase() : 0.10 * getPreuBase();
    }

    @Override
    public String toString() {
        return "Portàtil {" + super.toString() + "} Preu: " + super.getPreuBase() + " " + this.calculaDescompte();
    }
}