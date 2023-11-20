package ACT4_5;

public class UtilitatsRecOrdCerca {
    // ACT4_4_1
    /**
     * Calcula la potencia d'un nombre.
     *
     * @param base
     * @param exponent
     * @return la base elevat a l'exponent
     */
    public static double calculaPotencia(int base, int exponent) {
        if (exponent == 1) {
            return base;
        } else {
            return (base * calculaPotencia(base, exponent - 1));
        }
    } 
    
    // ACT4_4_2
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
    
    
    // ACT4_4_3
    /**
     * Calcula el fibonacci d'un nombre.
     *
     * @param base de càlciul de la sèrie
     * @return el fibonacci d'un numero
     */
    public static int sumaNaturals(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaNaturals(n - 1);
        }
    }

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
     * @param base de càlciul de la sèrie
     * @return el fibonacci d'un numero
     */
    public static int calculaFibonacci(int base) {
        if (base <= 1) {
            return base;
        } else {
            return calculaFibonacci(base - 1) + calculaFibonacci(base - 2);
        }
    }  
    
    // ACT4_5_6
    /** Comprova que l'array sigui de tres posicions i torna el resultat.
    * Si t� 3 posicioins ordena l'array.
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
    
    // ACT4_4_7
    /** Ordena un array segons l'algoritme de la bimbolla (versió 1)
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
                    // Realiza un intercambio si el elemento actual es mayor que el siguiente.
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
        
        return array;
    }
    
    // ACT4_4_8
    /** Cercar un n�mmero en un array
    * 
    * @param array on cal cercar
    * @param num a cercar
    * @return boolean
    */
    public static int cercaArray(int[] array, int num) {
        int izq = 0;
        int der = array.length - 1;

        while (izq <= der) {
            int medio = izq + (der - izq) / 2;

            if (array[medio] == num) {
                return medio; // 'num' trobat en la meitat de l'array
            } else if (array[medio] < num) {
                izq = medio + 1;
            } else {
                der = medio - 1;
            }
        }

        return -1; // si el 'num' no es troba, es retorna -1
    }
}


