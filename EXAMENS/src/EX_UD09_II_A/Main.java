package EX_UD09_II_A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {

    // Crea 3 objectes 'TipusIva' en un 'array'
    static TipusIva[] IVA = { new TipusIva("Exempt",0), 
                              new TipusIva("Reduït",0.10),
                              new TipusIva("Normal",0.21)
                            };
    static final int EXEMPT = 0;  // Índex per a 'Iva Exempt'
    static final int REDUIT = 1;  // Índex per a 'Iva Reduït'
    static final int NORMAL = 2;  // Índex per a 'Iva normal'
    
    public static void main(String[] args) {
        Supermercat supermercat = new Supermercat("Lidl", new ArrayList<>());
        Client client = new Client("Bernat Maimó", new ArrayList<>() );
        
        // Crea els productes i les afegeix a l''stock' de 'supermercat'
        CompraProductes(supermercat);
        
        // Mostra els productes de 'supermercat'
        System.out.println(supermercat.toString());
        System.out.println("---------------------");
        
        // Cerca els productres del supermercat i les afegeix al 'carrito' del 'client'
        VendaProductes(supermercat, client);
        
        // Mostra el 'carrito' del 'client'
        System.out.println(client.toString());
        System.out.println("---------------------");
        
        // Mostra l''stock del 'supermercat'
        System.out.println(supermercat.toString());
        
    }
    
    private static void CompraProductes(Supermercat supermercat) {
        Article producte;
        
        producte  = new Article("Pa moreno", 0.80, 1.75, IVA[EXEMPT]);
        supermercat.afegeixArticle(producte, 100);
        producte  = new Article("Ous", 0.02, 0.20, IVA[REDUIT]);
        supermercat.afegeixArticle(producte, 100);
        producte  = new Article("Galletes", 1.10, 2.25, IVA[NORMAL]);
        supermercat.afegeixArticle(producte, 100);
        producte  = new Article("Mermelada", 0.55, 1.40, IVA[NORMAL]);
        supermercat.afegeixArticle(producte, 100);
        producte  = new Article("Farina", 1.00, 1.85, IVA[REDUIT]);
        supermercat.afegeixArticle(producte, 100);
    }
    
    private static void VendaProductes(Supermercat supermercat, Client client) {
        client.afegeixAlCarrito(supermercat, "Ous", 10);
        client.afegeixAlCarrito(supermercat, "Mermelada", 10);
        client.afegeixAlCarrito(supermercat, "xxxxxx", 1);
    }
    
}