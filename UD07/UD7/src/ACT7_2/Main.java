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
            ArrayList<Compte> comptes1 = new ArrayList<>();
            ArrayList<Compte> comptes2 = new ArrayList<>();
            
            // Declarar i instanciar un compte bancari
            Compte compte1 = new Compte("0001","0001","01", "0000000001", 0);
            comptes1.add(compte1);
            
            // Declarar i instanciar un compte bancari
            Compte compte2 = new Compte("0001", "0001", "01", "0000000002", 0);
            comptes1.add(compte2);

           // Declarar i instanciar un compte bancari
            Compte compte3 = new Compte("0001", "0001", "01", "0000000003", 0);
            comptes2.add(compte3);
            
            // Declarar i instanciar un client
            Client client1 = new Client("Soler","Matemales", "Joan", comptes1);
            Client client2 = new Client("Vidal","Palmer", "Pere", comptes2);

            // Realitzar transaccions
            try {
                // Transaccions 'Client1'
                client1.realitzaTransaccio(compte1, 500.0);
                client1.realitzaTransaccio(compte1, -200.0);
                client1.realitzaTransaccio(compte2, 1000.0);
                client1.realitzaTransaccio(compte2, -500.0);
                
                // Transaccions 'Client2'
                client2.realitzaTransaccio(compte3, 500.0);
                client2.realitzaTransaccio(compte3, -1500.0);  // la transacció no es realitzarà
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Mostrar client i comptes
            System.out.println();
            System.out.println("INFORMACIONS CLIENTS");
            System.out.println(client1.toString());
            System.out.println("-----------------");
            System.out.println(client2.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}