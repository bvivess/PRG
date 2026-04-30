package EX_3_2.Classes;

import java.util.Objects;

/**
 * Representa un astronauta identificat pel seu nom complet (astronaut_id).
 */
public class Astronaut {

    private String id;   // nom complet p.ex. "Ed White"

    public Astronaut(String astronautId) {
        this.id = astronautId;
    }

    public String getId()             { return id; }
    public void setId(String id)      { this.id = id; }

    // ?? equals / hashCode basat en id ???????????????????????????????

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Astronaut)) return false;
        return Objects.equals(this.id, ((Astronaut) obj).id);
    }

    @Override
    public String toString() {
        return "Astronaut{id='" + id + "'}";
    }
}
