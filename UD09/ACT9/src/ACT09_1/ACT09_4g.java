package ACT09_1;

import java.io.*;

public class ACT09_4g {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("dades.txt")); // Obrir l'arxiu

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
        } catch (IOException e) {
            System.out.println("Error d'entrada/sortida");
        } finally {
            try {
                if (br != null)
                     br.close(); // Tancar el recurs (en aquest cas, el BufferedReader)
            } catch (Exception e) {
                System.out.println("Error al tancar el 'BufferedReader': " + e.getMessage());
            }
        }

    }
}