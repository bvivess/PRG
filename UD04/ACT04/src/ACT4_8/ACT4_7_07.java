package ACT4_8;

import ACT4_3.UtilitatsConsola;

public class ACT4_7_07 {
    public static void main(String[] args) {
        String cadena = UtilitatsConsola.llegirCadena("Introdueix una cadena: ");
        char lletra = UtilitatsConsola.llegirCar("Introdueix el caràcter a contar: ");

        int total = UtilitatsRecOrdCerca.comptaLletraEnCadena(cadena, lletra);
        System.out.println("El caràcter '" + lletra + "' apareix " + total + " vegades en '" + cadena + "'");
    }
}
