package EX_UD09_IIIB_BAK;

public class Main {

    // Crea 3 objectes 'TipusIva' en un 'array'
    static CompteComptable[] compteComptable = { new CompteComptable("4300",'D'), 
                                                 new CompteComptable("7000",'H'),
                                                 new CompteComptable("4400",'H'),
                                                 new CompteComptable("6000",'D'),
                            };
    static final int FACCLI_D = 0;  // Asiento factura client 'D'
    static final int FACCLI_H = 1;  // Asiento factura client 'H'
    static final int FACPRO_D = 2;  // Asiento factura proveïdor 'D'
    static final int FACPRO_H = 3;  // Asiento factura proveïdor 'H'
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
