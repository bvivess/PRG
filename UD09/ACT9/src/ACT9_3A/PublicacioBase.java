package ACT9_3A;

/**
 *
 * @author winadmin
 */
// Clase abstracta PublicacionBase
abstract class PublicacioBase implements Publicacio {
    private String titol;
    private int anyPublicacio;

    public PublicacioBase(String titulo, int anyPublicacio) {
        this.titol = titulo;
        this.anyPublicacio = anyPublicacio;
    }

    public String getTitol() {
        return titol;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }
}