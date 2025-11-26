package ACT4_4;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class UtilitatsClasses {
        
    /**
     *
     * @param array
     */
    public static void mostraArrayListInt(ArrayList<Integer> array) {
        String separador = "";
        System.out.print('[');
        for (Integer a : array) {
            System.out.print(separador + a);
            separador = ", ";
        }
        System.out.println(']');
    }
    
    public static void mostraArrayListStr(ArrayList<String> array) {
        String separador = "";
        System.out.print('[');
        for (String a : array) {
            System.out.print(separador + a);
            separador = ", ";
        }
        System.out.println(']');
    }

    /**
     * Crear un ArraList 
     *      s'avalua cada element de l'array en l'ArrayList
     * @return ArrayList 
     */    
    public static ArrayList<Integer> generaDiferents(int[] array) {
        ArrayList<Integer> resultat = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            boolean trobat = false;

            for (Integer r : resultat) {
                if (array[i] == r) {  // s'ha trobat un igual
                    trobat = true;
                    break;
                }
            }

            if (!trobat) {
                resultat.add(array[i]);
            }
        }
        return resultat;
    }
    
    /**
     * Crear un ArraList 
     *      s'avalua cada element de l'array en l'ArrayList
     * @return ArrayList 
     */    
    public static ArrayList<Integer> ordenaArray(int[] array) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        resultat.add(array[0]);
        for (int i=1; i<array.length; i++) {
            boolean trobat = false;
            for (int j=0; j<resultat.size(); j++) {
                if (array[i] < resultat.get(j))  {
                    resultat.add(j, array[i]);  // afegir en la posició 'j' de 'resultat'
                    trobat = true;
                    break;
                }
            }
            if (!trobat) {
                resultat.add(array[i]);  // afegir al final de 'resultat'
            }
        }
        return resultat;
    }
    
    /**
     * Crear un ArraList 
     *      s'avalua cada element de l'array en l'ArrayList
     * @return ArrayList 
     */    
    public static ArrayList<Integer> ordenaArraySenseRepeticions(int[] array) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        resultat.add(array[0]);
        for (int i=1; i<array.length; i++) {
            boolean trobat = false;
            for (int j=0; j<resultat.size(); j++) {
                if (array[i] == resultat.get(j)) {
                    trobat = true;
                    break;
                } else if (array[i] < resultat.get(j))  {
                    resultat.add(j, array[i]);  // afegir en la posició 'j' de 'resultat'
                    trobat = true;
                    break;
                }
            }
            if (!trobat) {
                resultat.add(array[i]);  // afegir al final de 'resultat'
            }
        }
        return resultat;
    }

    /**
     * Crear un ArraList 
     *      s'avalua cada element de l'array en l'ArrayList
     * @return ArrayList 
     */    
    public static ArrayList<Integer> obteParells(int[] array) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        for (int a : array) {
            if (a % 2 == 0)
                resultat.add(a);  // afegir en 'resultat'
        }
        return resultat;
    }
    
    /**
     * Crear un ArraList 
     *      s'avalua cada element de l'array en l'ArrayList
     * @return ArrayList 
     */    
    public static ArrayList<Integer> obteParellsOrdenat(int[] array) {
        ArrayList<Integer> resultat;

        // Cridada a 'obteParells'
        resultat = UtilitatsClasses.obteParells(array);  // 'obteParells'
        
        // Transforma la sortida d'un mètode en l'entrada del següent
        int[] array2 = ArrayListToArray(resultat);
       
        // Cridada a 'ordenaArray'
        resultat = UtilitatsClasses.ordenaArray( array2 );
        return resultat;
        
        // també
        // return UtilitatsClasses.ordenaArray( ArrayListToArray( UtilitatsClasses.obteParells(array) ));
    } 
    
    public static int[] ArrayListToArray(ArrayList<Integer> arrayL) {
        int[] resultat = new int[arrayL.size()];
        
        for (int i = 0; i < arrayL.size(); i++) {
            resultat[i] = arrayL.get(i);
        }
        
        return resultat;
    }
    
    /**
     * Crear un ArraList 
     *      s'avalua cada element de l'array en l'ArrayList
     * @return ArrayList 
     */    
    public static ArrayList<Integer> obteParellsOrdenatSenseRepeticions(int[] array) {
        // Cridada entre mètodes de manera directa
        return UtilitatsClasses.ordenaArraySenseRepeticions( ArrayListToArray( UtilitatsClasses.obteParells(array) ) );
    } 
    
 
    /**
     * Transforma un int[] a un ArrayList<Integer>
     * @param array --> int[]
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> arrayToArrayListInt(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int a : array) {
            arrayList.add(a);
        }
        
        return arrayList;
    }
    
    /**
    * Crear un ArrayList 
    *      s'avalua cada element de l'array en l'ArrayList
    *      si l'ArrayList es mantÃ© ordenat es poden estalviar 
    *      moltes lectures
    * @return ArrayList ordenat
    */
    public static ArrayList<Integer> mostraDiferentsMillorat(int[] array) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        for (int num : array) {
            int i = 0; // index on cal insertar en 'resultat'
            boolean trobat = false;
            
            for (Integer r : resultat) { // es cerca 'num' dins 'resultat'
                if( r == num) { // trobat, no cal insertar
                    trobat = true;
                    break;
                } else if (r > num) // no trobat, ni es trobarà  si l'ArrayList es manté ordenat, cal insertar
                    break;
                else // seguir cercant dins 'resultat'
                    i++;
            }
            if (!trobat) // afegir 'num' en la posició 'i' per mantenir l'ArrayList ordenat
                resultat.add(i,num);
        }
        
        return resultat;
    }
    
}
