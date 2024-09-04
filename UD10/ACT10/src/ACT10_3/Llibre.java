package ACT10_3;

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

    public Llibre(int idLlibre, String titol, String autor, int anyPublicacio) {
        this.idLlibre = idLlibre;
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idLlibre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Llibre other = (Llibre) obj;
        return Objects.equals(this.idLlibre, other.idLlibre);
    }

    
    
    @Override
    public String toString() {
        return "ID: " + idLlibre + " Títol: " + titol + " de " + autor + " (" + anyPublicacio + ")";
    }
}