import java.io.IOException;

/**23. Comprovar si un nombre recuperat de la línia de comandes és primer o no 
 * utilitzant un for i un break.
 * 
 * @author Joan Pons i Tugores
 */
public class ACT3_2_02 {

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(args[0]);
        boolean primer = true;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                primer = false;
                break;
            }
        }
        if (primer) {
            System.out.println("És primer");
        } else {
            System.out.println("No és primer");
        }
    }
}
