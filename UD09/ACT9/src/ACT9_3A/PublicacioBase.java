package ACT9_3A;

/**
 *
 * @author winadmin
 */
// Clase abstracta PublicacionBase
abstract class PublicacioBase implements Publicacio {
    private String titulo;
    private int anioPublicacion;

    public PublicacioBase(String titulo, int anioPublicacion) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
}