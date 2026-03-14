package ACT09_1;

public class ACT09_4B {
    public static void main(String[] args) {

        try {
            System.out.println("Nivell 1");
            try {
                System.out.println("Nivell 2");
                try {
                    System.out.println("Nivell 3");
                    int x = 10 / 0;
                } catch (ArithmeticException e) {
                    System.out.println("Error aritmètic capturat al nivell 3");
                }
                int[] v = {1,2,3};
                System.out.println(v[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error d'índex capturat al nivell 2");
            }
            String s = null;
            System.out.println(s.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointer capturat al nivell 1");
        } finally {
            System.out.println("Fi del programa");
        }
    }
}