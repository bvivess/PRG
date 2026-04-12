package ACT11_0B;


public class Producte {
    private int id;
    private String descripcio;
    private double preu;

    public Producte(int id, String descripcio, double preu) {
        this.id = id;
        this.descripcio = descripcio;
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Producte{" + "id=" + id + ", descripcio=" + descripcio + ", preu=" + preu + '}';
    }

}
