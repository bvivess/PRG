package ACT5_1;

/**
 *
 * @author T.Vives
 */
public class ACT5_1_1 {
    
    public static void main(String[] args) {
        int a=UtilitatsConsola.llegirSencer("Introdueixi el divident: ");
        int b=UtilitatsConsola.llegirSencer("Introdueixi el divisor: ");
        
        try {
            int c = a / b;
            System.out.println("La divisió és: " + c);
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            System.out.println("No és possible realitzar la divisió per 0");
        }
    }
}
