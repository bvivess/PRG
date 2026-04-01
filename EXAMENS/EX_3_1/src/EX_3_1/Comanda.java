package EX_3_1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Comanda implements Comparable<Comanda> {
    private int id;
    private String nomClient;
    private int taula;
    private LocalDateTime timestamp;
    private List<Plat> plats;
    private EstatComanda estat;

    public Comanda(int id, String nomClient, int taula, LocalDateTime timestamp, List<Plat> plats) {
        this.id = id;
        this.nomClient = nomClient;
        this.taula = taula;
        this.timestamp = timestamp;
        this.plats = plats;
        this.estat = EstatComanda.PENDENT;
    }
    
    public Comanda(int id) {
        this.id = id;
    }

    public void setEstat(EstatComanda estat) {
        this.estat = estat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comanda)) return false;
        Comanda c = (Comanda) o;
        return id == c.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Comanda c) {
        return this.timestamp.compareTo(c.timestamp);  // també: Integer.compare(this.id, c.id);
    }
    
    public int getId() { 
        return id; 
    }
    
    public String getNomClient() { 
        return nomClient; 
    }
    
    public int getTaula() { 
        return taula; 
    }
    
    public List<Plat> getPlats() { 
        return plats; 
    }
    
    public EstatComanda getEstat() { 
        return estat; 
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", client='" + nomClient + '\'' +
                ", taula=" + taula +
                ", Data=" + timestamp +
                ", plats=" + plats +
                ", estat=" + estat.getDescripcio() +
                '}';
    }
}
