package EX3_1;

public class Client implements Comparable<Client>{
    private String id;
    private String name;

    // Constructor
    public Client(String id, String name) {
        setId(id);
        setName(name);
    }

    // Getters i Setters
    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalArgumentException {
        if (id == null)
            throw new IllegalArgumentException ("Client.id incorrecte");
        else
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException ("Client.name incorrecte");
        else
            this.name = name;
    }

    // compareTo
    @Override
    public int compareTo(Client o) {
        return this.id.compareTo(o.id); // Ordenar per Name;
    }   

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id.equals(client.id);
    }

    // hashCode
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // toString
    @Override
    public String toString() {
        return "Client{" +
               "Id='" + id + '\'' +
               ", name='" + name + '\'' +
               '}';
    }

}

