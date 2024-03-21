package ACT11_3;

/**
 *
 * @author winadmin
 */
public class Llibre {
    private String titol;
    private String autor;
    private int anyPublicacio;

    public Llibre(String titol, String autor, int anyPublicacio) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    @Override
    public String toString() {
        return titol + " de " + autor + " (" + anyPublicacio + ")";
    }
}