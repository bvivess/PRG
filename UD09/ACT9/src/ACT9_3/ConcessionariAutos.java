package ACT9_3;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class ConcessionariAutos implements Concessionari {
    private ArrayList<Automobil> autos = new ArrayList<>();

    public void agregarAutomovil(Automobil auto) {
        autos.add(auto);
    }

    @Override
    public double calculaIngressos() {
        double ingresos = 0;
        for (Automobil auto : autos) {
            ingresos += auto.getPreu() + auto.calculaImpost();
        }
        return ingresos;
    }

    @Override
    public String toString() {
        String text="";
        
        for (Automobil a : autos )
            text += "\n\t" + a.toString();

        return "ConcessionariAutos {" + text + "\n" + "}";
    }
}