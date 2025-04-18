package ACT11_6A.Classes;

import java.time.LocalDate;
import java.util.List;

public class Venda {
    int id;
    LocalDate dataVenda;
    Client client;
    List<Producte> productes;

    public Venda(int id, LocalDate dataVenda, Client client, List<Producte> productes) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.client = client;
        this.productes = productes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Producte p : productes) {
            sb.append(p.id).append(";");
        }
        return id + "," + client.id + "," + dataVenda + "," + sb.toString();
    }
}