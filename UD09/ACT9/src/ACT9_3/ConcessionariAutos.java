package ACT9_3;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class ConcessionariAutos implements Concessionari {
    private ArrayList<Automobil> autos = new ArrayList<>();
    private ArrayList<Camio> camions = new ArrayList<>();

    @Override
    public double calculaIngressos() {
        double ingresos = 0;
        for (Automobil a : autos) {
            ingresos += a.getPreu() + a.calculaImpost();
        }
        for (Camio c : camions) {
            ingresos += c.getPreu() + c.calculaImpost();
        }
        return ingresos;
    }

    @Override
    public String toString() {
        String text="";
        
        for (Automobil a : autos )
            text += "\n\t" + a.toString() + " Imposts: " + a.calculaImpost();
        for (Camio c : camions )
            text += "\n\t" + c.toString() + " Imposts: " + c.calculaImpost();
        
        return "ConcessionariAutos {" + text + "\n" + "}";
    }
    
    public void setAutomovil(Automobil auto) {
        autos.add(auto);
    }
    
    public void setCamio(Camio camio) {
        camions.add(camio);
    }
}