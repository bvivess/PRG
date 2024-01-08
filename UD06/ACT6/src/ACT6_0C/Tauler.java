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

    public void inicializarTauler() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                caselles[i][j] = new Casella(i, j);
            }
        }
    }
    
    public void mostraTauler() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(caselles[i][j]);
            }
        }
    }

    // ...
}

