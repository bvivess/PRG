package ACT10_0P;

import java.time.LocalDate;

/**
 *
 * @author winadmin
 */
public class Main1 {

    public static void main (String[] args) {
        //LocalDate dataActual = LocalDate.now();
        LocalDate dataActual = LocalDate.of(2026,03,16);

        int mes = dataActual.getMonthValue();
        int dia = dataActual.getDayOfMonth();
        int any = dataActual.getYear();
        System.out.println("Data: " + dia + "/" + mes + "/" + any);
    }

}
