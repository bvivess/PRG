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
        double ingressos = 0;
        ingressos += calculaIngressosAutos() + calculaIngressosCamions();
        return ingressos;
    }
    
    private double calculaIngressosAutos() {
        double ingressos = 0;
        for (Automobil a : this.autos) {
            ingressos += a.getPreu() + a.calculaImpost();
        }
        return ingressos;
    }
    
    private double calculaIngressosCamions() {
        double ingressos = 0;

        for (Camio c : this.camions) {
            ingressos += c.getPreu() + c.calculaImpost();
        }
        return ingressos;
    }
    
    public void setAutomobil(Automobil auto) {
        autos.add(auto);
    }
    
    public void setCamio(Camio camio) {
        camions.add(camio);
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

}