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
    public void realitzaTransaccio(String banc, String oficina, String dc, String numCompte, double quantitat) {
        String compteComplet1 = banc+oficina+dc+numCompte;
        String compteComplet2 = "";
        // ha de modificar el saldo del compte del client
        
        for (Compte compte:comptes) {
            compteComplet2 = compte.banc+compte.oficina+compte.dc+compte.numCompte;
            if (compteComplet1.equalsIgnoreCase(compteComplet2))
                if (quantitat > 0)
                    compte.ingresar(quantitat);
                else if (quantitat < 0) 
                    compte.reintegrar(Math.abs(quantitat));  // valor en positiu de 'quantitat'
        }

    }
}

