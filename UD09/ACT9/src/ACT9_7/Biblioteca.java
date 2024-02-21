package ACT9_7;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Biblioteca {
    private ArrayList<Llibre> llibres;

    public Biblioteca() {
        this.llibres = new ArrayList<>();
    }

    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public Llibre buscarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equals(titol)) {
                return llibre;
            }
        }
        return null;
    }

    public void mostrarLlibres() {
        System.out.println("Llibres disponibles a la biblioteca:");
        for (Llibre llibre : llibres) {
            System.out.println(llibre);
        }
    }
}