package ACT5_2A;

/**
 *
 * @author T.Vives
 */
public class Compte {
    public String banc;  // codi banc: String 4 posicions
    public String oficina;  // codi oficina: String 4 posicions
    public String dc;  // digits control: String 2 posicions
    public String numCompte; // n�m compte: String 10 posicions
    public double saldo;  // no �s possible un valor negatiu per aquest atribut

    public void ingresa(double quantitat) {
        // ha d'incrementar la 'quantitat' al saldo del compte
        saldo = saldo + quantitat;
        System.out.println("Ingr�s de " + quantitat + " en el compte " + banc + "-" + oficina + "-" + dc + "-" + numCompte);
    }

    public void reintegra(double quantitat) {
        // ha de decrementar la 'quantitat' al saldo del compte. 
        // Si la quantitat �s superior al saldo cal donar un avis
        if (quantitat <= saldo) {
            saldo = saldo - quantitat;
            System.out.println("Retirada de " + quantitat + " del compte " + banc + "-" + oficina + "-" + dc + "-" + numCompte);
        } else 
            System.out.println("Saldo insuficient " + saldo + " en el compte " + banc + "-" + oficina + "-" + dc + "-" + numCompte);
    }
}
