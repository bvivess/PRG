package ACT6_2A;

/**
 *
 * @author T.Vives
 */
public class Client {
    // Atributs
    public String llinatge1;
    public String llinatge2;
    public String nom;
    public Compte compte;

    // Mètodes
    public void realitzaTransaccio(double quantitat) {
        // ha de modificar el saldo del compte del client
        if (quantitat > 0) {
            compte.ingresar(quantitat);
        } else if (quantitat < 0) {
            compte.reintegrar(Math.abs(quantitat));  // valor en positiu de 'quantitat'
        }
    }
}

