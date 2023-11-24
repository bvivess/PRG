package ACT5_1;

/**
 *
 * @author T.Vives
 */
public class ACT5_1_2 {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int posicio = UtilitatsConsola.llegirSencer("Introdueixi la posició de l'array a llegir (0-" + (array.length-1) + "): ");
        
        try {
            
            System.out.println(array[posicio]);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("S'ha excedit la longitud de l'array");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Error d'execució");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error generalyy");
        }
    }
}
