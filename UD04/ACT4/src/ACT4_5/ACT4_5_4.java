package ACT4_5;

import ACT4_3.UtilitatsConsola;

public class ACT4_5_4 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi un número sencer: ");

        for (int i = 0; i < base; i++) {
            System.out.print(UtilitatsRecOrdCerca.sumarNaturals(i) + " ");
        }
    }
}
