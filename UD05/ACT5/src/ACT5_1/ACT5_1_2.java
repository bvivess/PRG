package ACT5_1;

/**
 *
 * @author T.Vives
 */
public class ACT5_1_2 {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        
        try {
            for (int i=0; i<=array.length; i++)
                System.out.println(array[i]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("S'ha excedit la longitud de l'array");
        }
    }
}
