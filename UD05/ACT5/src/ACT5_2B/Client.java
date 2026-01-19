package ACT5_2B;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Client {
    // Atributs
    public String llinatge1;
    public String llinatge2;
    public String nom;
    public ArrayList<Compte> comptes;

    // Mètodes
    public void realitzaTransaccio(Compte compteAModificar, double quantitat) {
        // es cerca 'compteAModificar' per a cada 'comptePossible' del 'client'
        for (Compte comptePossible:comptes) {
            if ((compteAModificar.banc.equalsIgnoreCase(comptePossible.banc)) &&
                (compteAModificar.oficina.equalsIgnoreCase(comptePossible.oficina)) &&
                (compteAModificar.dc.equalsIgnoreCase(comptePossible.dc)) && 
                (compteAModificar.numCompte.equalsIgnoreCase(comptePossible.numCompte)))  // es compara pels 4 atributs de cada compte
                if (quantitat > 0) {
                    comptePossible.ingresa(quantitat);
                    break;
                } else if (quantitat < 0) { 
                    comptePossible.reintegra(Math.abs(quantitat));  // valor en positiu de 'quantitat'
                    break;
                }
        }
    }

    public String mostraClient() {
        String text;
        text = "Client " + this.nom + " " + this.llinatge1 + " " + this.llinatge2;
        for (Compte c : this.comptes) 
            text += "\n\t" + c.banc + "-" + c.oficina + "-" + c.dc + "-" + c.numCompte + ": " + c.saldo;
        return text;
    }

}

