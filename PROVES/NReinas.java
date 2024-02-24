import java.util.ArrayList;
import java.util.List;

public class NReinas {
    private static final int NREINAS = 8;
    private static List<Integer> sol = new ArrayList<>();
    private static int nro_sol = 1;

    public static void main(String[] args) {
        System.out.println("SOLUCIONES AL PROBLEMA DE LAS " + NREINAS + " REINAS");
        sol = new ArrayList<>(NREINAS);
        for (int i = 0; i < NREINAS; i++) {
            sol.add(0);
        }
        reinas(0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    private static boolean contiene(List<Integer> lista, int valor) {
        return lista.contains(valor);
    }

    private static void reinas(int k, List<Integer> col, List<Integer> diag45, List<Integer> diag135) {
        if (k == NREINAS) {
            System.out.printf("%3d:", nro_sol++);
            for (int j = 0; j < NREINAS; j++) {
                System.out.printf(" (%d,%d)", j + 1, sol.get(j));
            }
            System.out.println();
        } else {
            for (int j = 1; j <= NREINAS; j++) {
                if (!contiene(col, j) && !contiene(diag45, j - k) && !contiene(diag135, j + k)) {
                    sol.set(k, j);
                    col.add(j);
                    diag45.add(j - k);
                    diag135.add(j + k);

                    reinas(k + 1, col, diag45, diag135);

                    col.remove(col.size() - 1);
                    diag45.remove(diag45.size() - 1);
                    diag135.remove(diag135.size() - 1);
                }
            }
        }
    }
}

