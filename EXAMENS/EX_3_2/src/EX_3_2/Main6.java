package EX_3_2;

import java.util.List;

public class Main6 {

    /* ==== Interfície funcional pròpia ==================================== */
    @FunctionalInterface
    public interface Sumador {
        int suma(List<Integer> llista);
    }

    public static void main(String[] args) {

        // Implementació 1 ─ programació imperativa (classe anònima)
        Sumador sumaImperatiu = new Sumador() {
            @Override
            public int suma(List<Integer> llista) {
                int total = 0;
                for (Integer n : llista) {        // bucle clàssic
                    total += n;
                }
                return total;
            }
        };

        // Implementació 2 ─ expressió λ amb forEach
        Sumador sumaLambda = llista -> {
            final int[] total = {0};              // contenidor mutable
            llista.forEach(n -> total[0] += n);   // acumulació amb forEach
            return total[0];
        };

        // Dades de prova
        List<Integer> nums = List.of(3, 7, 2, 8);

        // Ús i sortida
        System.out.println("Imperatiu  : " + sumaImperatiu.suma(nums)); // 20
        System.out.println("Lambda     : " + sumaLambda.suma(nums));    // 20
    }
}

