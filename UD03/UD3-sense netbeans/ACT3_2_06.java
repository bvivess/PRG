import java.io.IOException;

/**27. Al programa anterior eliminau els break del switch. Que passa? Reescriviu-lo 
 *de forma que amb el mínim de codi obtinguem el resultat correcte.
 * 
 * @author Joan Pons i Tugores
 */
public class ACT3_2_06 {

    public static void main(String[] args) throws IOException {
        //Tercera forma
        for (char c = 'a'; c <= 'z'; c++) {
            switch (c) {
                case 'a': 
                case 'e': 
                case 'i': 
                case 'o': 
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
