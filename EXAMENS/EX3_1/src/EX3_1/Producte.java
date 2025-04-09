package EX3_1;

public class Producte implements Comparable <Producte> {
    private String id;
    private String name;
    private int price;

    // Constructor
    public Producte(String id, String name, int price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    // Getters i Setters
    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalArgumentException {
        if (id == null)
            throw new IllegalArgumentException ("Producte.id incorrecte");
        else
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (id == null)
            throw new IllegalArgumentException ("Producte.name incorrecte");
        else
            this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws IllegalArgumentException {
        if (price < 0 )
            throw new IllegalArgumentException ("Producte.price incorrecte");
        else
            this.price = price;
    }
    
    // compareTo
    @Override
    public int compareTo(Producte o) {
        return this.name.compareTo(o.name); // Ordenar per Name;
    } 

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producte product = (Producte) obj;
        return id.equals(product.id);
    }

    // hashCode
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // toString
    @Override
    public String toString() {
        return "Product{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", importe=" + price +
               '}';
    }
}

