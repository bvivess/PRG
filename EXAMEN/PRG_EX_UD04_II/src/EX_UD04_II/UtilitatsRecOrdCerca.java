package EX_UD04_II;



public class UtilitatsRecOrdCerca {
    // ACT4_5_1
    /**
     * Calcula la potència d'un nombre.
     *
     * @param base
     * @param exponent
     * @return la base elevat a l'exponent
     */
    public static double calculaPotencia(int base, int exponent) {
        System.out.print(" >" + base + "^" + exponent);
        if (exponent == 1) {
            System.out.print(" ***" + (base));
            return base;
        } else {
            System.out.print(" *2x" + (base) + "^" + (exponent-1));
            return (base * calculaPotencia(base, exponent - 1));
        }
    } 
    
    // ACT4_5_2
    /**
     * Calcula el factorial d'un nombre.
     *
     * @param base factorial
     * @return el factorial d'un nombre
     */
    public static double calculaFactorial(int base) {
        if (base == 1) {
            return base;
        } else {
            return (base * calculaFactorial(base-1));
        }
    }   
    
    // ACT4_5_3
    /**
     * Calcula la suma de númoeros sencers a partir d'un donat.
     *
     * @param n de càlcul de la sèrie
     * @return la suma a partir d'un donat
     */
    public static int sumaSuma(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaSuma(n - 1);
        }
    }

    // ACT4_5_4
    /**
     * Calcula el màxim comú divisor entre 2 números: 
     * https://www.youtube.com/watch?v=Aa7gIGtGARs
     *
     * @param a,b 
     * @return el MCD d'a i b
     */
    public static int calculaMCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculaMCD(b, a % b);
        }
    }
    
    // ACT4_5_5
    /**
     * Calcula el fibonacci d'un nombre.
     *
     * @param base de càlcul de la serie
     * @return el fibonacci d'un numero
     */
    public static int calculaFibonacci(int base) {
        System.out.print(" >" + base);
        if (base == 0) {
            System.out.print(" ***" + (base));
            return base;
        } else if (base == 1) {
            System.out.print(" ***" + (base));
            return base;
        }
        else {
            System.out.print(" *" + (base-1) + " *" + (base-2));
            return calculaFibonacci(base - 1) + calculaFibonacci(base - 2);
        }
    }  
    
    // ACT4_5_6
    /** Comprova que l'array sigui de tres posicions i torna el resultat.
    * Si té 3 posicioins ordena l'array.
    * 
    * @param array amb 3 elements
    * @return boolean
    */
    public static boolean ordenaArray3(int[] array){
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
    
    // ACT4_5_7
    /** Ordena un array segons l'algoritme de la bimbolla (versiÃ³ 1)
    * https://es.wikipedia.org/wiki/Ordenamiento_de_burbuja
    * 
    * @param array que cal ordenar
    * @return array ordenat
    */
    public static int[] ordenaArrayBimbolla(int[] array){
        int n = array.length;
        int aux;
        
        for (int i=1; i<n-1; i++) {
            for (int j=0; j<n-1; j++) {
                if (array[j] > array[j+1]) {
                    // Realitza l'intercanvi entre les posicions [j] i [j+1]
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
        
        return array;
    }
    
    // ACT4_5_8
    /** Cercar un númmero en un array ordenat
    * 
    * @param array on cal cercar
    * @param num a cercar
    * @return boolean
    */
    public static int cercaArray(int[] array, int num) {
        int esq = 0;
        int dre = array.length - 1;

        while (esq <= dre) {
            int mig = esq + (dre - esq) / 2;

            if (array[mig] == num) {
                return mig; // 'num' trobat en la meitat de l'array
            } else if (array[mig] < num) {
                esq = mig + 1;
            } else {
                dre = mig - 1;
            }
        }

        return -1; // si el 'num' no es troba, es retorna -1
    }
    
    // ACT4_5_9
    /** Cercar un númmero en un array ordenat de manera recursiva
    * 
    * @param array on cal cercar
    * @param num a cercar
    * @return boolean
    */
    public static int cercaArrayRecursiu(int[] array, int num, int esq, int dre) {
        // Caso base1: numero no s'ha trobat
        if (esq > dre) {
            return -1;
        }

        // Calcular el índice medio
        int mig = (esq + dre) / 2;

        // Caso base2: numero s'ha trobat
        if (array[mig] == num) {
            return mig;
        } else if (array[mig] < num) {
            // seguir cercant en la part dreta de l'array
            return cercaArrayRecursiu(array, num, mig + 1, dre);
        } else {
            // seguir cercant en la part esquerra de l'array
            return cercaArrayRecursiu(array, num, esq, mig - 1);
        }
    }
}