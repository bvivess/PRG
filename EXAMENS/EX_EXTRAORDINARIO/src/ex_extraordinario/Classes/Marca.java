package ex_extraordinario.Classes;

public class Marca implements Comparable<Marca>{
    private int idMarca;
    private String nombreMarca;
    private String paisOrigen;

    public Marca(int idMarca, String nombreMarca, String paisOrigen) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.paisOrigen = paisOrigen;
    }

    public Marca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    @Override
    public int compareTo(Marca o) {
        return this.paisOrigen.compareTo(o.paisOrigen);
    }

    // getters, setters 

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idMarca;
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
        final Marca other = (Marca) obj;
        return this.idMarca == other.idMarca;
    }

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", nombreMarca=" + nombreMarca + ", paisOrigen=" + paisOrigen + '}';
    }
    
}