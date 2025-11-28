package EX_1_2;

import java.util.ArrayList;

public class UtilExamen {
    public static int[] ArrayListToArray(ArrayList<Integer> arrayL) {
        int[] resultat = new int[arrayL.size()];
        
        for (int i = 0; i < arrayL.size(); i++) {
            resultat[i] = arrayL.get(i);
        }
        
        return resultat;
    }
    
    public static ArrayList<Integer> ArrayToArrayList(int[] array){
        ArrayList<Integer> resultat = new ArrayList<>();
        
        for (int a : array) {
            resultat.add(a);
        }
        
        return resultat;
    }
    
    public static void mostraArrayListInt(ArrayList<Integer> array) {
        String separador = "";
        System.out.print('[');
        for (Integer a : array) {
            System.out.print(separador + a);
            separador = ", ";
        }
        System.out.println(']');
    }
    
    public static ArrayList<Integer> obteRepetits(int[] array1, int[] array2) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        for (int a1 : array1)
            for (int a2 : array2)
                if (a1 == a2) {
                    resultat.add(a1);
                    break;
                }
            
        return  resultat;
    }
    
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
}
