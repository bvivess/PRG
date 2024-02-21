package ACT9_6B;

import ACT9_6A.*;

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
        return (getConsumEnergetic() > 20) ? 0.15 * getPreu() : 0.10 * getPreu();
    }

    @Override
    public String toString() {
        return "Portàtil {" + super.toString() + "} Preu: " + super.getPreu() + " " + this.calculaDescompte();
    }
}