package examen;

import java.util.ArrayList;

public class EX_2 {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(1);
        array.add(2);
        
        System.out.println(array);
        System.out.println(ordenaArrayList(array));
    }
    
    public static ArrayList<Integer> ordenaArrayList(ArrayList<Integer> array ) {
        ArrayList<Integer> arrayOrdenat = new ArrayList<>();
        Integer a;
        int j;

        arrayOrdenat.add(array.get(0));
        for (int i= 1; i < array.size(); i++) {
            j = 1;
            a = array.get(i);
            for (Integer o : arrayOrdenat) {
                if ((a < o)) {
                    arrayOrdenat.add(j-1, a);
                    break;
                }
                j++;
            }
        }
        return arrayOrdenat;
    }

}
