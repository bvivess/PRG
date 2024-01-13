package ACT8_2;

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
    public Client(String llinatge1, String llinatge2, String nom, ArrayList<Compte> comptes) {
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
        this.nom = nom;
        this.comptes = comptes;
    }

    // Mètodes específics
    public void realitzaTransaccio(Compte compteAModificar, double quantitat) {
        // es cerca 'compteAModificar' per a cada 'comptePossible' del 'client'
        for (Compte comptePossible:comptes) {
            if (comptePossible.equals(compteAModificar))  // es compara pels 4 atributs de cada compte
                if (quantitat > 0) {
                    comptePossible.ingresa(quantitat);
                    break;
                } else if (quantitat < 0) { 
                    comptePossible.reintegra(Math.abs(quantitat));  // valor en positiu de 'quantitat'
                    break;
                }
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
        String texte;
        texte = "Client " + this.nom + " " + this.llinatge1 + " " + this.llinatge2;
        texte += "\namb SALDO:\n";
        for (Compte compte:comptes) 
            texte += "\t"+compte.getBanc() + "-" + compte.getOficina() + "-" + compte.getDc() + "-" + compte.getNumCompte() + ": " + compte.getSaldo() +"\n";
        
        return texte;
    }
    
}