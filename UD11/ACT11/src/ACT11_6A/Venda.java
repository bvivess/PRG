package ACT11_6A;

import java.time.LocalDate;
import java.util.List;

public class Venda {
    int idVenda;
    Client client;
    List<Producte> productes;
    LocalDate dataVenda;

    public Venda(int idVenda, Client client, List<Producte> productes, LocalDate dataVenda) {
        this.idVenda = idVenda;
        this.client = client;
        this.productes = productes;
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
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

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Producte p : productes) {
            sb.append(p.id).append(";");
        }
        return idVenda + "," + client.id + "," + dataVenda + "," + sb.toString();
    }
}