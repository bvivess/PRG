package ACT5_2A;

/**
 *
 * @author T.Vives
 */
public class Compte {
    public String banc;  // codi banc: String 4 posicions
    public String oficina;  // codi oficina: String 4 posicions
    public String dc;  // digits control: String 2 posicions
    public String numCompte; // núm compte: String 10 posicions
    public double saldo;  // no és possible un valor negatiu per aquest atribut

    public void ingresa(double quantitat) {
        // ha d'incrementar la 'quantitat' al saldo del compte
        saldo = saldo + quantitat;
        System.out.println("Ingrès de " + quantitat + " en el compte " + this.banc + "-" + this.oficina + "-" + this.dc + "-" + this.numCompte);
    }

    public void reintegra(double quantitat) {
        // ha de decrementar la 'quantitat' al saldo del compte. 
        // Si la quantitat és superior al saldo cal donar un avis
        if (quantitat <= this.saldo) {
            this.saldo = this.saldo - quantitat;
            System.out.println("Retirada de " + quantitat + " del compte " + this.banc + "-" + this.oficina + "-" + this.dc + "-" + this.numCompte);
        } else 
            System.out.println("Saldo insuficient " + this.saldo + " en el compte " + this.banc + "-" + this.oficina + "-" + this.dc + "-" + this.numCompte);
    }

    public String mostraCompte() {
        return "Compte{" + "banc=" + this.banc + ", oficina=" + this.oficina + ", dc=" + this.dc + ", numCompte=" + this.numCompte + ", saldo=" + this.saldo + '}';
    }
    
    
}
