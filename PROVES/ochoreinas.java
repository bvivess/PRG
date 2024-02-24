public class EightQueens {
    private static final int N = 8; // Tamaño del tablero

    public static void main(String[] args) {
        solveQueens();
    }

    // Función principal para resolver el problema de las 8 reinas
    public static void solveQueens() {
        int[][] board = new int[N][N];
        if (solveQueensUtil(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No se encontró una solución.");
        }
    }

    // Función recursiva para resolver el problema de las 8 reinas
    private static boolean solveQueensUtil(int[][] board, int col) {
        if (col >= N) {
            return true; // Todas las reinas están colocadas
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Coloca una reina en la posición (i, col)

                // Recursivamente coloca las reinas restantes
                if (solveQueensUtil(board, col + 1)) {
                    return true;
                }

                // Si colocar una reina en (i, col) no conduce a una solución, retrocede
                board[i][col] = 0;
            }
        }
        return false; // No se puede encontrar una solución en esta columna
    }

    // Función para verificar si es seguro colocar una reina en la posición (row, col)
    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Verifica la fila en la izquierda
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Verifica la diagonal superior izquierda
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Verifica la diagonal inferior izquierda
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true; // Es seguro colocar una reina en esta posición
    }

    // Función para imprimir el tablero
    private static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
