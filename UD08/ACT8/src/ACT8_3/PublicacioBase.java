package ACT8_3;

import java.util.Objects;

/**
 *
 * @author winadmin
 */
// Clase abstracta PublicacionBase
abstract class PublicacioBase implements Publicacio {
    private String titol;
    private int anyPublicacio;
    private double preu;

    public PublicacioBase(String titol, int anyPublicacio, double preu) {
        setTitol(titol);
        setAnyPublicacio(anyPublicacio);
        setPreu(preu);
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "PublicacioBase {" + "titol=" + this.getTitol() + ", anyPublicacio=" + this.getAnyPublicacio() + ", preuBase=" + this.preu + "}";
    }
    
    
}