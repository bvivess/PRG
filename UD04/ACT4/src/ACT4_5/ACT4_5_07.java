package ACT4_5;

import ACT4_3.UtilitatsConsola;

public class ACT4_5_07 {
    public static void main(String[] args) {
        String cadena = UtilitatsConsola.llegirCadena("Introdueix una cadena: ");
        char lletra = UtilitatsConsola.llegirCar("Introdueix el car�cter a contar: ");

        int total = UtilitatsRecOrdCerca.contaLletraEnCadena(cadena, lletra);
        System.out.println("El car�cter '" + lletra + "' apareix " + total + " vegades en '" + cadena + "'");
    }
}
