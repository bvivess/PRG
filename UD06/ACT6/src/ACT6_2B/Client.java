package ACT6_2B;

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
        // ha de modificar el saldo del compte del client
        for (Compte comptePossible:comptes) {  // es cerca 'compte1' per a cada compte del 'client'
            if ((compteAModificar.banc.equalsIgnoreCase(comptePossible.banc)) &&
                (compteAModificar.oficina.equalsIgnoreCase(comptePossible.oficina)) &&
                (compteAModificar.dc.equalsIgnoreCase(comptePossible.dc)) && 
                (compteAModificar.numCompte.equalsIgnoreCase(comptePossible.numCompte)))  // es compara pels 4 atributs de cada compte
                if (quantitat > 0)
                    comptePossible.ingresa(quantitat);
                else if (quantitat < 0) 
                    comptePossible.reintegra(Math.abs(quantitat));  // valor en positiu de 'quantitat'
        }
    }
    
    public void mostraSaldo() {
        // ha de mostrar cada un dels comptes del client amb els seus saldos
        for (Compte compte:comptes) 
            System.out.println(compte.banc + compte.banc + "-" + compte.oficina + "-" + compte.dc + "-" + compte.numCompte + ": " + compte.saldo);
    }
}

