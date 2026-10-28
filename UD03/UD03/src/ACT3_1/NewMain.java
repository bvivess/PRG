import    java.util.Arrays;

public class NewMain {


    
    public static void main(String[] args) {
        int[] numeros = {5, 2, 8, 1, 3};
        
        System.out.println(numeros[0]);
        
        Arrays.sort(numeros);
        
        System.out.println(numeros[0]);
        
        System.out.println(Arrays.toString(numeros));
    }

}
