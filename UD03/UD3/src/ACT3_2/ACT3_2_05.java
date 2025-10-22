package ACT3_2;

import java.io.IOException;

/**26. Creau una classe que mostri les lletres de l'alfabet i al costat indiqui si es tracta d'una vocal o d'una consonant. En farem tres versions:
1. Amb un  if per a cada vocal if() else if....
2. Amb un sol if() else
3. Amb un switch. Recordau de posar break a cada case
 * 
 * @author Joan Pons i Tugores
 */
public class ACT3_2_05 {

    public static void main(String[] args) throws IOException {
		System.out.println("1A FORMA ------------------------");
        //Primera forma
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'a') {
                System.out.println(c + " és vocal");
            } else if (c == 'e') {
                System.out.println(c + " és vocal");
            } else if (c == 'i') {
                System.out.println(c + " és vocal");
            } else if (c == 'o') {
                System.out.println(c + " és vocal");
            } else if (c == 'u') {
                System.out.println(c + " és vocal");
            } else {
                System.out.println(c + " és consonant");
            }
        }
		System.out.println("2A FORMA ------------------------");
        //Segona forma
        for (char c = 'a'; c <= 'z'; c++) {
            if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {
                System.out.println(c + " és vocal");
            } else {
                System.out.println(c + " és consonant");
            }
        }
		System.out.println("3A FORMA ------------------------");
        //Tercera forma
        for (char c = 'a'; c <= 'z'; c++) {
            switch (c) {
                case 'a': {
                    System.out.println(c + " és vocal");
                    break;
                }
                case 'e': {
                    System.out.println(c + " és vocal");
                    break;
                }
                case 'i': {
                    System.out.println(c + " és vocal");
                    break;
                }
                case 'o': {
                    System.out.println(c + " és vocal");
                    break;
                }
                case 'u': {
                    System.out.println(c + " és vocal");
                    break;
                }
                default: {
                    System.out.println(c + " és consonant");
                    break;
                }

            }
        }
    }
}
