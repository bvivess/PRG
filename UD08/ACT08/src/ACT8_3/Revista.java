package ACT8_3;

/**
 *
 * @author winadmin
 */
// Clase Revista
class Revista extends PublicacioBase {
    private int numeroEdicio;

    public Revista(String titol, int anioPublicacio, double preu, int numeroEdicio) {
        super(titol, anioPublicacio, preu);
        this.numeroEdicio = numeroEdicio;
    }

    @Override
    public double calculaPrecio() {
        return getPreu() * 1.10;
    }

    public void setNumeroEdicio(int numeroEdicio) {
        this.numeroEdicio = numeroEdicio;
    }

    @Override
    public String toString() {
        return super.toString() + " Revista: " + getTitol() + ", Número d'Edició: " + numeroEdicio + ", A?o: " + getAnyPublicacio();
    }
    
}