package ACT5_2A;

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
            compte.ingresa(quantitat);
        } else if (quantitat < 0) {
            compte.reintegra(Math.abs(quantitat));  // valor en positiu de 'quantitat'
        }
    }

    public String mostraClient() {
        return "Client{" + "llinatge1=" + this.llinatge1 + ", llinatge2=" + this.llinatge2 + ", nom=" + this.nom + ", compte=" + this.compte.mostraCompte() + '}';
    }
    
    
}

