import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int num1;
        int num2;
        System.out.println("Ingrese su primer número: ");
        num1 = scanner.nextInt();

        System.out.println("Ingrese su segundo número: ");
        num2 = scanner.nextInt();

        for(int i = Math.max(2, num1); i<=num2; i++){  
            boolean esPrimo = true;
            for (int divisor = 2; divisor<i; divisor++){

                if (i%divisor == 0){
                    esPrimo = false;
                    break;
                }
            }
            if(esPrimo){
                System.out.println("Su número " + i + " es primo");
            } else{
                System.out.println("Su número " + i + " NO es primo");
            }
        }
        scanner.close();
    }
}
