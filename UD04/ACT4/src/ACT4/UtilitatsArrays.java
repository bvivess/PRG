package ACT4;

import java.util.Scanner;

/**
 * @author joan
 */

public class UtilitatsArrays {
    /**
     * Mostra l'array de sencers que rep com a paràmetre per pantalla
     *
     * @param array L'array que conté els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(int[] array) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < array.length; i++) {
            System.out.print(separador + array[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a paràmetre per pantalla
     *
     * @param array L'array que conté els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(boolean[] array) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < array.length; i++) {
            System.out.print(separador + array[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a paràmetre per pantalla
     *
     * @param array L'array que conté els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(double[] array) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < array.length; i++) {
            System.out.print(separador + array[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a paràmetre per pantalla
     *
     * @param array L'array que conté els valors que volem mostrar per pantalla.
     */
    
    public static void mostraArray(String[] array) {
        String separador = "";
        System.out.print('[');

        for (String a : array) {
            System.out.print(separador + a);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    // ACT 4_2
    /**
     * Suma els sencers d'un array
     * @param array 
     * @return int.
     */
    public static int sumaArray(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    //ACT4_3
    /**
     * Genera un array de sencers de la longitud demanada
     * @param longitud La longitud de l'array
     * @param minim, el min valor
     * @param maxim, el max valor
     * @return L'array emplenat de forma aleatòria.
     */
    public static int[] generaArray(int longitud, int minim, int maxim) {
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++) {
            array[i] = minim + (int) (Math.random() * (maxim - minim + 1));
        }
        return array;
    }
     
    //ACT4_4
    /**
     * Compara dos arrrays de sencers de qualsevol longitud
     *
     * @param array1 El primer array
     * @param array2 El segon array
     * @return El resultat
     */
    public static boolean comparaArrays(int[] array1, int[] array2) {
        boolean sonIguals = true;
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    sonIguals = false;
                    break;
                }
            }
        } else {
            sonIguals = false;
        }
        return sonIguals;
    }
    
    //ACT4_5
    /**
     * Ordena l'array. Si no té tres posicions no fa res.
     *
     * @param array
     */
    public static void ordenaArray(int[] array) {
        int aux;
        if (array.length == 3) {
            if (array[0] > array[1]) {
                aux = array[1];
                array[1] = array[0];
                array[0] = aux;
            }
            if (array[0] > array[2]) {
                aux = array[2];
                array[2] = array[0];
                array[0] = aux;
            }
            if (array[1] > array[2]) {
                aux = array[2];
                array[2] = array[1];
                array[1] = aux;
            }
        }
    }
    
    // ACT4_6
    /** Comprova que l'array sigui de tres posicions i torna el resultat.
    * Si és de tres posicioins ordena l'array.
    *
    * ATENCIÓ, EN AQUEST CAS CAL CANVIAR LA SIGNATURA AMB EL MÈTODE ANTERIOR
    * 
    * @param array
    * @return boolean
    */
    public static boolean ordenaArray2(int[] array){
        boolean resultat=true;
        int aux;
        if(array.length==3){
            if(array[0]>array[1]){
                aux=array[1];
                array[1]=array[0];
                array[0]=aux;
            }
            if(array[0]>array[2]){
                aux=array[2];
                array[2]=array[0];
                array[0]=aux;
            }
            if(array[1]>array[2]){
                aux=array[2];
                array[2]=array[1];
                array[1]=aux;
            }
        }else{
            resultat=false;
        }
        return resultat;
    }

}
