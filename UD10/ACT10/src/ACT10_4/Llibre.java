package ACT10_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author winadmin
 */
public class Llibre {
    private int idLlibre;
    private String titol;
    private String autor;
    private int anyPublicacio;
    private List<Anomalia> anomalies;

    public Llibre(int idLlibre, String titol, String autor, int anyPublicacio) {
        this.idLlibre = idLlibre;
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        this.anomalies = new ArrayList<>();
    }
    
    public boolean afegeixAnomalia(Anomalia anomalia) {  // afegeix 'anomalia' en 'Llibre'
        if (!cercaAnomalia(anomalia)) 
            return this.anomalies.add(anomalia);
        return false;
    }
    
    public boolean eliminaAnomalia(Anomalia anomalia) {
        return this.getAnomalies().remove(anomalia);
    }
    
    private boolean cercaAnomalia(Anomalia anomalia) {  // cercar en 'List'
        int i = this.anomalies.indexOf(anomalia);
        return (i != -1);
    }
    
    public int getIdLlibre() {
        return idLlibre;
    }
    
    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }
    
    public List<Anomalia> getAnomalies() {
        return anomalies;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idLlibre);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Llibre l = (Llibre) o;
        return this.idLlibre == l.idLlibre;
    }
    
    @Override
    public String toString() {
        String texte = "";
        texte = "ID: " + idLlibre + " Títol: " + titol + " de " + autor + " (" + anyPublicacio + ")";
        texte += " Anomalies: {";
        for (Anomalia a : this.anomalies)
            texte += a.getDescripcio() + " ";
        texte += "}";
        return texte;
    }
}