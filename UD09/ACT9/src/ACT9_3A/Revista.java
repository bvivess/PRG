package ACT9_3A;

/**
 *
 * @author winadmin
 */
// Clase Revista
class Revista extends PublicacioBase {
    private int numeroEdicion;
    private double precio;

    public Revista(String titulo, int anioPublicacion, int numeroEdicion, double precio) {
        super(titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.precio = precio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Revista: " + getTitulo() + ", Número de Edición: " + numeroEdicion + ", A?o: " + getAnioPublicacion());
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }
}