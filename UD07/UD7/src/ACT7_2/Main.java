package ACT7_2;

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
            Compte compte1 = new Compte("0001","0001","01", "0000000001",0);
            comptes.add(compte1);
            
            // Declarar i instanciar un compte bancari
            Compte compte2 = new Compte("0001", "0001", "01", "0000000002", 0);
            comptes.add(compte2);

            // Declarar i instanciar un client
            Client client1 = new Client("Joan","Soler","Matemales", comptes);

            // Realitzar transaccions
            try {
                client1.realitzaTransaccio(compte1,500.0);
                client1.realitzaTransaccio(compte1,-200.0);
                client1.realitzaTransaccio(compte2,1000.0);
                client1.realitzaTransaccio(compte2,-1500.0);  // transacció no es realitzarà
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            // Mostrar saldo final
            client1.mostraClient();
            System.out.println("amb SALDO:" );
            client1.mostraSaldo();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

