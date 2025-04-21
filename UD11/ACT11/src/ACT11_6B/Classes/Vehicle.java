package ACT11_6B.Classes;

public class Vehicle {
    private String matricula;
    private String marca;
    private String model;
    private Client client;

    public Vehicle(String matricula, String marca, String model, Client client) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.client = client;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", client=" + client + '}';
    }
    
}
