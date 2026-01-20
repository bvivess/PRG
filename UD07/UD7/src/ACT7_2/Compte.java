package ACT7_2;

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
        this.setBanc(banc);
        this.setOficina(oficina);
        this.setDc(dc);
        this.setNumCompte(numCompte);
        this.ingresa(saldo);
    }

    // Mètodes específics
    public void ingresa(double quantitat) {
        // ha d'incrementar la 'quantitat' al saldo del compte
        //saldo += quantitat;
        System.out.println("Ingrès de " + quantitat + " del compte " + this.banc + "-" + this.oficina + "-" + this.dc + "-" + this.numCompte);
        setSaldo(this.saldo + quantitat);
    }

    public void reintegra(double quantitat) {
        // ha de decrementar la 'quantitat' al saldo del compte. 
        // Si la quantitat és superior al saldo cal donar un avis
        /*
        if (quantitat <= this.saldo) {
            saldo -= quantitat;
            System.out.println("Retirada de " + this.quantitat + " del compte " + this.banc + "-" + this.oficina + "-" + this.dc + "-" + this.numCompte);
        } else {
            System.out.println("Saldo insuficient " + this.saldo + " en el compte " + this.banc + "-" + this.oficina + "-" + this.dc + "-" + this.numCompte);
        }
        */
        System.out.println("Retirada de " + quantitat + " del compte " + this.banc + "-" + this.oficina + "-" + this.dc + "-" + this.numCompte);
        setSaldo(this.saldo - quantitat);
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
            throw new IllegalArgumentException("Import negatiu no és possible.");
    }

    @Override
    public boolean equals(Object o) {
        Compte c = (Compte) o;
        
        if ((c.banc.equalsIgnoreCase(this.banc)) &&
            (c.oficina.equalsIgnoreCase(this.oficina)) &&
            (c.dc.equalsIgnoreCase(this.dc)) &&
            (c.numCompte.equalsIgnoreCase(this.numCompte)))
            return true;
        else
            return false;
    }
    
    @Override
    public String toString() {
        return this.getBanc() + "-" + this.getOficina() + "-" + this.getDc() + "-" + this.getNumCompte() + ": " + this.getSaldo();
    }
}
