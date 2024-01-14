package ACT6_2B;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Declarar i instanciar un compte bancari
            ArrayList<Compte> comptes = new ArrayList<>();
            Compte compte1 = new Compte();
            compte1.banc = "0001";
            compte1.oficina = "0001";
            compte1.dc = "01";
            compte1.numCompte = "0000000001";
            compte1.saldo = 0;  // no cal (valor per defecte)
            comptes.add(compte1);
            
            // Declarar i instanciar un compte bancari
            Compte compte2 = new Compte();
            compte2.banc = "0001";
            compte2.oficina = "0001";
            compte2.dc = "01";
            compte2.numCompte = "0000000002";
            compte2.saldo = 0;  // no cal (valor per defecte)
            comptes.add(compte2);

            // Declarar i instanciar un client
            Client client1 = new Client();
            client1.llinatge1 = "Soler";
            client1.llinatge2 = "Matemales";
            client1.nom = "Joan";
            client1.comptes = comptes;  // atenció a aquesta asignació per referència !!

            // Realitzar transaccions
            client1.realitzaTransaccio(compte1,500.0);
            client1.realitzaTransaccio(compte1,-200.0);
            client1.realitzaTransaccio(compte2,1000.0);
            client1.realitzaTransaccio(compte2,-500.0);

            // Mostrar saldo final
            client1.mostraClient();
            System.out.println(" amb SALDO:" );
            client1.mostraSaldo();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

