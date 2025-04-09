package EX3_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Factura {
    private String Id;
    private LocalDate data;
    private Client client;
    private List<Producte> productes;  // Llista de productes associats a la factura

    // Constructor
    public Factura(String id, LocalDate data, Client client, List<Producte> productes) {
        setId(id);
        setData(data);
        setClient(client);
        setProductes(productes);
    }

    // Getters i Setters
    public String getId() {
        return Id;
    }

    public void setId(String id) throws IllegalArgumentException {
        if (id == null)
            throw new IllegalArgumentException ("Factura.id incorrecte");
        else
            this.Id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws IllegalArgumentException {
        if (data == null | data.getYear() < 2000)
            throw new IllegalArgumentException ("Factura.data incorrecte");
        else
            this.data = data;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Producte> getProductes() {
        return productes;
    }

    public void setProductes(List<Producte> productes) {
        this.productes = productes;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Factura factura = (Factura) obj;
        return Id.equals(factura.Id);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Id.hashCode();
    }

    // toString
    @Override
    public String toString() {
        List<Producte> productesOrdenat = this.productes;
        Collections.sort(productesOrdenat);
                
        float total = 0;
        for (Producte p : productes)
            total += p.getPrice();
        
        return "Factura{" +
               "Id='" + Id + '\'' +
               ", data=" + data +
               ",\n\t - client=" + client.toString() +
               ",\n\t - productes=" + productesOrdenat.toString() +
               "}" + 
               ", \n\t TOTAL=" + total;
    }
}


