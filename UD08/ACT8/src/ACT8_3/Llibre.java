package ACT8_3;

/**
 *
 * @author winadmin
 */
// Clase Libro
class Llibre extends PublicacioBase {
    private String autor;


    public Llibre(String titulo, int anyPublicacio, double preu, String autor) {
        super(titulo, anyPublicacio, preu);
        setAutor(autor);
    }

    @Override
    public double calculaPrecio() {
        return getPreu() * 1.21;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Libre: " + getTitol() + ", Autor: " + autor + ", Any: " + getAnyPublicacio();
    }
}
