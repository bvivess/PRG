package ACT8_7;

import java.util.Objects;

/**
 *
 * @author winadmin
 */
class Llibre {
    private String titol;
    private String autor;
    private int anyPublicacio;
    private double preu;

    public Llibre(String titol, String autor, int anyPublicacio, double preu) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        this.preu = preu;
    }
    
    public Llibre(String titol) {
        this.titol = titol;
    }

    // Getters i setters

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.titol);
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
        return Objects.equals(this.titol, other.titol);
    }

    @Override
    public String toString() {
        return "Llibre {" +
                "titol: '" + titol + '\'' +
                ", autor: '" + autor + '\'' +
                ", anyPublicacio: " + anyPublicacio +
                ", preu: " + preu +
                '}';
    }
}