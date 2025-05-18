package PROVA;

class Vehicle {
    private String marca;
    private String model;
    private int any;
    private double preu;

    public Vehicle(String marca, String model, int any, double preu) {
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.preu = preu;
    }

    public String getMarca() { return marca; }
    public String getModel() { return model; }
    public int getAny() { return any; }
    public double getPreu() { return preu; }

    public String getMarcaModel() { return marca + " " + model; }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - %.0f EUR", marca, model, any, preu);
    }

}

