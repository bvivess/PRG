package ACT09_1;

public class ACT09_4A {
    public static void main(String[] args) {

        try {
            System.out.println("Inici del try exterior");

            try {
                int a = 10 / 0;   // Error: divisió per zero
            } catch (ArithmeticException e) {
                System.out.println("Error aritmètic capturat al try interior");
            }

            int[] numeros = {1,2,3};
            System.out.println(numeros[5]);  // Error fora del try interior

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error d'índex capturat al try exterior");
        }

        System.out.println("Final del programa");
    }
}