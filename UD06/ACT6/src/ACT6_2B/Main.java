package ACT6_2B;

import ACT6_2A.*;
import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Declarar i instanciar un compte bancari
            Compte compte = new Compte();
            compte.banc = "0001";
            compte.oficina = "0001";
            compte.dc = "01";
            compte.numCompte = "0000000002";
            ArrayList<Compte> comptes = new ArrayList<>();
            comptes.add(compte);

            // Declarar i instanciar un client
            Client client1 = new Client();
            client1.nom = "Joan";
            client1.llinatge1 = "Soler";
            client1.llinatge2 = "Matemales";
            client1.comptes = new ArrayList<Compte>();
            client1.comptes = comptes;  // atenció a aquesta asignació per referència !!

            // Realitzar transaccions
            client1.realitzaTransaccio(compte.banc, compte.oficina, compte.dc, compte.numCompte,500.0);
            client1.realitzaTransaccio(compte.banc, compte.oficina, compte.dc, compte.numCompte,-200.0);

            // Mostrar saldo final
            System.out.println("Client " + client1.nom + " " + client1.llinatge1 + " amb SALDO " );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}

