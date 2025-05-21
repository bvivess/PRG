package ACT12_2A;

import java.util.Objects;

public class Department  implements Comparable<Department> {
    String id;

    public Department(String id) {
        this.id = id;
    }
    
    @Override
    public int compareTo(Department d) {
        return this.compareTo(d);
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Department other = (Department) obj;
        return Objects.equals(this.id, other.id);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Department{" + "id=" + id + '}';
    }
    
}
