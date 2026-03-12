package ACT09_1;

import java.io.*;

public class ACT09_4E {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("dades.txt"));

            String linia;
            while((linia = br.readLine()) != null) {
                try {
                    int numero = Integer.parseInt(linia);
                    try {
                        int resultat = 100 / numero;
                        System.out.println(resultat);
                    }
                    catch (ArithmeticException e) {
                        System.out.println("Divisió per zero");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("No és un número: " + linia);
                }
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println("Error d'entrada/sortida");
        }

    }
}