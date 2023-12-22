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
    public void realitzaTransaccio(Compte compte1, double quantitat) {
        String compteComplet1 = compte1.banc + compte1.oficina + compte1.dc + compte1.numCompte;
        String compteComplet2 = "";
        // ha de modificar el saldo del compte del client
        
        for (Compte compte2:comptes) {
            compteComplet2 = compte2.banc+compte2.oficina+compte2.dc+compte2.numCompte;
            if (compteComplet1.equalsIgnoreCase(compteComplet2))
                if (quantitat > 0)
                    compte2.ingresar(quantitat);
                else if (quantitat < 0) 
                    compte2.reintegrar(Math.abs(quantitat));  // valor en positiu de 'quantitat'
        }
    }
    
    public void mostraSaldo() {
        for (Compte compte:comptes) 
            System.out.println(compte.banc + compte.banc + "-" + compte.oficina + "-" + compte.dc + "-" + compte.numCompte + ": " + compte.saldo);
    }
}

