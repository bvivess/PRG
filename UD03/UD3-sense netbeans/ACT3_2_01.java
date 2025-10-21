/**20. Creau un programa que donat un nombre sencer mostri per pantalla tots els 
 * seus divisors, per exemple, per a 6 mostraria 1, 2, 3, 6.
 * 
 * @author Joan Pons i Tugores
 */
public class ACT3_2_01 {


    public static void main(String[] args) {

        int num = 6;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }

    }
}
