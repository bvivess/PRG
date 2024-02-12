package ACT11_0G;

public class Main {
    public static void main(String[] args) {
        double num1 = 10;
        double num2 = 5;

        // Executa cada operació matemàtica binària
        for (OperacioMatematica o : OperacioMatematica.values()) {
            System.out.println(o + ": " + o.executa(num1, num2));
        }
    }
}
