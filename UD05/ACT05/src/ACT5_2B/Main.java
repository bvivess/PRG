package ACT5_2B;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main(String[] args) {
        // Declarar i instanciar un compte bancari
        ArrayList<Compte> comptes1 = new ArrayList<>();
        ArrayList<Compte> comptes2 = new ArrayList<>();

        Compte compte1 = new Compte();
        compte1.banc = "0001";
        compte1.oficina = "0001";
        compte1.dc = "01";
        compte1.numCompte = "0000000001";
        compte1.saldo = 0;  // no cal (valor per defecte)
        comptes1.add(compte1);

        // Declarar i instanciar un compte bancari
        Compte compte2 = new Compte();
        compte2.banc = "0001";
        compte2.oficina = "0001";
        compte2.dc = "01";
        compte2.numCompte = "0000000002";
        compte2.saldo = 0;  // no cal (valor per defecte)
        comptes1.add(compte2);

        // Declarar i instanciar un compte bancari
        Compte compte3 = new Compte();
        compte3.banc = "0001";
        compte3.oficina = "0001";
        compte3.dc = "01";
        compte3.numCompte = "0000000002";
        compte3.saldo = 0;  // no cal (valor per defecte)
        comptes2.add(compte3);

        // Declarar i instanciar un client
        Client client1 = new Client();
        client1.llinatge1 = "Soler";
        client1.llinatge2 = "Matemales";
        client1.nom = "Joan";
        client1.comptes = comptes1;  // atenció a aquesta asignació per referència !!

        Client client2 = new Client();
        client2.llinatge1 = "Vidal";
        client2.llinatge2 = "Palmer";
        client2.nom = "Pere";
        client2.comptes = comptes2;  // atenció a aquesta asignació per referència !!

        client1.realitzaTransaccio(compte1, 500.0);
        client1.realitzaTransaccio(compte1, -200.0);
        client1.realitzaTransaccio(compte2, 1000.0);
        client1.realitzaTransaccio(compte2, -500.0);
        client2.realitzaTransaccio(compte3, 500.0);
        client2.realitzaTransaccio(compte3, -1500.0); // transacció no es realitzarà

        // Mostrar dades
        System.out.println(client1.mostraClient());

        System.out.println(client2.mostraClient());

    }
}

