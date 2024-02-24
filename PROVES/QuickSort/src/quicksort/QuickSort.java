package quicksort;

public class QuickSort {
    public static void main(String[] args) {
        int[] numeros = {5, 2, 9, 1, 5, 6};
        
        System.out.println("Array antes de ordenar:");
        imprimirArray(numeros);
        
        quickSort(numeros, 0, numeros.length - 1);
        
        System.out.println("\nArray después de ordenar:");
        imprimirArray(numeros);
    }
    
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(arr, inicio, fin);
            
            // Llamada recursiva para ordenar las dos subarrays
            quickSort(arr, inicio, indiceParticion - 1);
            quickSort(arr, indiceParticion + 1, fin);
        }
    }
    
    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin]; // Tomamos el último elemento como pivote
        int i = (inicio - 1); // Índice del elemento más pequeño
        
        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                
                // Intercambia arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Intercambia arr[i+1] y el pivote
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        
        return i + 1;
    }
    
    public static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
