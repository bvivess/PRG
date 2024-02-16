package ACT9_3A;

/**
 *
 * @author winadmin
 */
// Clase Revista
class Revista extends PublicacioBase {
    private int numeroEdicio;
    private double preu;

    public Revista(String titol, int anioPublicacio, int numeroEdicio, double preu) {
        super(titol, anioPublicacio);
        this.numeroEdicio = numeroEdicio;
        this.preu = preu;
    }

    @Override
    public double calculaPrecio() {
        return preu;
    }

    @Override
    public String toString() {
        return "Revista: " + getTitol() + ", Número d'Edició: " + numeroEdicio + ", Any: " + getAnyPublicacio();
    }
    
}