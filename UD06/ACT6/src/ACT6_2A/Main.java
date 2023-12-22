package ACT6_2A;

/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Declarar i instanciar un compte bancari
            Compte compte1 = new Compte();
            compte1.banc = "0149";
            compte1.oficina = "0001";
            compte1.dc = "31";
            compte1.numCompte = "1234567890";

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
            System.out.println("Client " + client1.nom + " " + client1.llinatge1 + " amb SALDO " + 
                               client1.compte.saldo );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}

