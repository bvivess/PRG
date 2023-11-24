package ACT5_1;

import java.util.Scanner;

public class ACT5_1_3A {

    public static void main(String[] args) {
        int numero;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introdueixi un número sencer: ");
        numero = scanner.nextInt();

        System.out.println("Ha introduit: " + numero);

        scanner.close();
    }
    
}
