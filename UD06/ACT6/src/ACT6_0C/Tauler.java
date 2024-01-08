package ACT6_0C;

/**
 *
 * @author winadmin
 */
public class Tauler {
    private Casella[][] caselles;

    public Tauler() {
        caselles = new Casella[8][8];
        inicializarTauler();
    }

    private void inicializarTauler() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                caselles[fila][columna] = new Casella(fila, columna);
            }
        }
    }
    
    private void mostraTauler() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                System.out.println(caselles[fila][columna]);
            }
        }
    }

    // ...
}

