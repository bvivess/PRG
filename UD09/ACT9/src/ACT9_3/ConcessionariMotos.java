package ACT9_3;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class ConcessionariMotos implements Concessionari {
    private ArrayList<Motocicleta> motos = new ArrayList<>();

    @Override
    public double calculaIngressos() {
        double ingresos = 0;
        for (Motocicleta moto : motos) {
            ingresos += moto.getPreu() + moto.calculaImpost();
        }
        return ingresos;
    }
    
    @Override
    public String toString() {
        String text="";
        
        for (Motocicleta m : motos )
            text += "\n\t" + m.toString() + " Imposts: " + m.calculaImpost();;

        return "ConcessionariAutos {" + text + "\n" + "}";
    }
    
    public void setMotocicleta(Motocicleta moto) {
        motos.add(moto);
    }
}