package ACT09_1;

public class ACT09_4C {
    public static void main(String[] args) {

        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error de divisió");
            try {
                int[] v = {1,2,3};
                System.out.println(v[4]);
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Error d'índex dins del catch");
            }
        } finally {
            System.out.println("Finally exterior");
        }

        System.out.println("Programa continua");
    }
}