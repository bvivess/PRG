package ACT5_2A;

/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main(String[] args) {

        // Declarar i instanciar un compte bancari
        Compte compte1 = new Compte();
        compte1.banc = "0001";
        compte1.oficina = "0001";
        compte1.dc = "01";
        compte1.numCompte = "0000000001";
        compte1.saldo = 0;  // No cal

        // Declarar i instanciar un client
        Client client1 = new Client();
        client1.nom = "Joan";
        client1.llinatge1 = "Soler";
        client1.llinatge2 = "Matemales";
        client1.compte = compte1;

        // Realitzar transaccions
        client1.realitzaTransaccio(500.0);
        client1.realitzaTransaccio(-200.0);

        // Mostrar saldo final
        System.out.println( client1.mostraClient() );
    }
    
}

