package ACT3_2;

import java.io.IOException;

/**
 * 24. Comprovar si un nombre recuperat de la línia de comandes és primer o no
 * utilitzant un while.
 *
 * @author Joan Pons i Tugores
 */
public class ACT3_2_03 {

    public static void main(String[] args) throws IOException {
        //Comprova que ens hagin passat un i només un argument
        if (args.length == 1) {
            //El transformam a int
            int num = Integer.parseInt(args[0]);

            int i = 2;
            //En trobar un divisor acaba. Acabarà per que com a mínim quan 
            //i==num la condició no serà certa.
            while (num % i != 0) {
                i++;
            }
            if (i == num) {
                System.out.println("És primer");
            } else {
                System.out.println("No és primer");
            }
        } else {
            System.err.println("Ha de posar un únic argument");
        }
    }
}
