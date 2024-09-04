package ACT8_6B;

/**
 *
 * @author winadmin
 */
public class Televisor extends Electronic {

    public Televisor(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla, String processador, int ram, int hdd) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla, processador, ram, hdd);
    } 

    @Override
    public double calculaDescompte() {
        return (getMidaPantalla() > 40) ? 0.12 * getPreu() : 0.08 * getPreu();
    }
    
    @Override
    public String toString() {
        return "Televisor {" + super.toString() + "} Preu: " + super.getPreu() + " " + this.calculaDescompte();
    }
}