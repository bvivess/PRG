package ACT6_0C;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        int[][] tauler = new int[8][8];
        ArrayList<Casella> cuc = new ArrayList<>();  // cada segment del cuc està és un element de l'ArrayList	

        Casella segment1 = new Casella();
        segment1.fila = 2;
        segment1.columna = 3;
        cuc.add(segment1);  // l'objecte 'cuc' té un primer segment en la 'fila'=2 i 'columna'=3
        Casella segment2 = new Casella();
        segment2.fila = 2;
        segment2.columna = 4;
        cuc.add(segment2);  // l'objecte 'cuc' té un segon segment en la 'fila'=2 i 'columna'=4
        // ...
    }

}