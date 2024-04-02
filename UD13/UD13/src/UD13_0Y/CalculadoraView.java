package UD13_0Y;

// Vista (View): Es la interfaz de usuario que presenta los datos al usuario final. 
// La vista se encarga de mostrar la información al usuario de manera adecuada, 
// también puede ser responsable de recoger la entrada del usuario.
import java.util.Scanner;

class CalculadoraView {
    public void mostrarResultado(int resultado) {
        System.out.println("El resultado de la suma es: " + resultado);
    }
    
    public int obtenerNumero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        return scanner.nextInt();
    }
}