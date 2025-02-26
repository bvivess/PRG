package ACT8_6B;

/**
 *
 * @author winadmin
 */
class Telefon extends Electronic {
    public Telefon(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla, String processador, int ram, int hdd) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla, processador, ram, hdd);
    }

    @Override
    public double calculaDescompte() {
        return (getGarantiaMesos() < 6) ? 0.10 * super.getPreuBase() : 0.05 * super.getPreuBase();
    }

    @Override
    public String toString() {
        return "Telèfon {" + super.toString() + "} Preu: " + super.getPreuBase() + " " + this.calculaDescompte();
    }
}