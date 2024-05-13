package UD13_0Y;

// View: La vista s'encarrega de mostrar la informació a l'usuari de manera adequada, 
// també pot ser responsable de recollir l'entrada de l'usuari.

import java.util.Scanner;

class CalculadoraView {
    public int LlegeixNumero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        return scanner.nextInt();
    }
    
    public void mostraResultat(int resultado) {
        System.out.println("El resultado de la suma es: " + resultado);
    }
}