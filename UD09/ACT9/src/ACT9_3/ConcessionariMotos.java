package ACT9_3;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class ConcessionariMotos implements Concessionari {
    private ArrayList<Motocicleta> motos = new ArrayList<>();

    public void agregarMotocicleta(Motocicleta moto) {
        motos.add(moto);
    }

    @Override
    public double calculaIngressos() {
        double ingresos = 0;
        for (Motocicleta moto : motos) {
            ingresos += moto.getPreu() + moto.calculaImpost();
        }
        return ingresos;
    }
}