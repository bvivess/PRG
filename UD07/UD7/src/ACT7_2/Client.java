package ACT7_2;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Client {
    // Atributs
    private String llinatge1;
    private String llinatge2;
    private String nom;
    private ArrayList<Compte> comptes;

    // Constructor
    public Client(String llinatge1, String llinatge2, String nom) {
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
        this.nom = nom;
        this.comptes = new ArrayList<Compte>();
    }
    
    public Client(String llinatge1, String llinatge2, String nom, ArrayList<Compte> comptes) {
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
        this.nom = nom;
        this.comptes = comptes;
    }

    // Mètodes específics
    public void afegeixCompte(Compte compte) {
        this.comptes.add(compte);
    }
    
    public void realitzaTransaccio(Compte compteAModificar, double quantitat) {
        int i = this.comptes.indexOf(compteAModificar);

        System.out.println("Transaccio al compte: " +
                compteAModificar.getNumCompte() + " " + quantitat);

        if (i != -1) {
            Compte c = this.comptes.get(i);

            if (quantitat > 0)
                c.ingresa(quantitat);
            else if (quantitat < 0)
                c.reintegra(Math.abs(quantitat));
        }
    }
    
    // Getters i Setters
    public String getLlinatge1() {
        return llinatge1;
    }

    public void setLlinatge1(String llinatge1) {
        this.llinatge1 = llinatge1;
    }

    public String getLlinatge2() {
        return llinatge2;
    }

    public void setLlinatge2(String llinatge2) {
        this.llinatge2 = llinatge2;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(ArrayList<Compte> comptes) {
        this.comptes = comptes;
    }
        
    @Override
    public String toString() {
        String texte = "Client " + this.nom + " " + this.llinatge1 + " " + this.llinatge2;
        double saldo=0;
        
        texte += "\namb COMPTES:\n";
        for (Compte c : comptes) {
            texte += "\t" + c .toString() +"\n";
            saldo += c .getSaldo();
        }
        texte += "\n amb SALDO TOTAL CLIENT: " + saldo;
        return texte;
    }
    
}