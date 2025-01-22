package ACT6_4;

import java.util.Objects;

/**
 *
 * @author T.Vives
 */
public class Compte {
    // El codi d'un compte està format per 4 atribut: banc+oficina+dc+numCompte
    private String banc;  // codi banc: String 4 posicions
    private String oficina;  // codi oficina: String 4 posicions
    private String dc;  // digits control: String 2 posicions
    private String numCompte; // núm compte: String 10 posicions
    private double saldo;  // no és possible un valor negatiu per aquest atribut

    // Constructor
    
    public Compte(String banc, String oficina, String dc, String numCompte, double saldo) {
        this.banc = banc;
        this.oficina = oficina;
        this.dc = dc;
        this.numCompte = numCompte;
        this.saldo = saldo;
    }

    // Mètodes específics
    public void ingresa(double quantitat) {
        // ha d'incrementar la 'quantitat' al saldo del compte
        //saldo += quantitat;
        setSaldo(saldo + quantitat);
        System.out.println("Ingrès de " + quantitat + " en el compte " + banc + "-" + oficina + "-" + dc + "-" + numCompte);
    }

    public void reintegra(double quantitat) {
        // ha de decrementar la 'quantitat' al saldo del compte. 
        // Si la quantitat és superior al saldo cal donar un avis
        /*
        if (quantitat <= saldo) {
            saldo -= quantitat;
            System.out.println("Retirada de " + quantitat + " del compte " + banc + "-" + oficina + "-" + dc + "-" + numCompte);
        } else {
            System.out.println("Saldo insuficient " + saldo + " en el compte " + banc + "-" + oficina + "-" + dc + "-" + numCompte);
        }
        */
        setSaldo(saldo - quantitat);
        System.out.println("Retirada de " + quantitat + " del compte " + banc + "-" + oficina + "-" + dc + "-" + numCompte);
    }
    
    // Getters i Setters
    public String getBanc() {
        return banc;
    }

    public void setBanc(String banc) {
        this.banc = banc;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0)
            this.saldo = saldo;
        else
            throw new IllegalArgumentException(this.numCompte + ": No és possible un Import negatiu en compte.");
    }
    
}
