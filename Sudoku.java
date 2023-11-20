import java.util.Scanner;

public class Sudoku {
    private static int[][] board = new int[9][9];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (!isSudokuSolved()) {
            makeMove();
            printBoard();
        }

        System.out.println("¡Felicidades, has resuelto el Sudoku!");
        scanner.close();
    }

    private static void initializeBoard() {
        // Aquí puedes inicializar el tablero de Sudoku. 0 representa una celda vacía.
        // Este es solo un ejemplo. Puedes proporcionar tu propio tablero inicial.
        board = new int[][] {
                {5, 3, 1, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
    }

    private static void printBoard() {
        System.out.println(" -----------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if (j % 3 == 2) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (i % 3 == 2) {
                System.out.println(" -----------------------");
            }
        }
    }

    private static void makeMove() {
        System.out.println("Ingrese fila y columna para su próximo movimiento (por ejemplo, 3 4): ");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;

        if (isValidMove(row, col)) {
            System.out.println("Ingrese el número para colocar en la celda (1-9): ");
            int number = scanner.nextInt();

            if (isValidNumber(number)) {
                board[row][col] = number;
                System.out.println("Movimiento válido. ¡Buena jugada!");
            } else {
                System.out.println("Número inválido. Inténtalo de nuevo.");
            }
        } else {
            System.out.println("Movimiento inválido. Inténtalo de nuevo.");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 9 && col >= 0 && col < 9 && board[row][col] == 0;
    }

    private static boolean isValidNumber(int number) {
        return number >= 1 && number <= 9;
    }

	private static boolean isSudokuSolved() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					return false; // Hay al menos una celda vacía
				}
			}
		}
		return isValidRows() && isValidColumns() && isValidSquares();
	}

    private static boolean isValidRows() {
        for (int i = 0; i < 9; i++) {
            if (!isValidSet(board[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidColumns() {
        for (int j = 0; j < 9; j++) {
            int[] column = new int[9];
            for (int i = 0; i < 9; i++) {
                column[i] = board[i][j];
            }
            if (!isValidSet(column)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSquares() {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] square = new int[9];
                int index = 0;
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        square[index++] = board[row][col];
                    }
                }
                if (!isValidSet(square)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSet(int[] set) {
        int[] count = new int[10]; // Índices del 1 al 9
        for (int num : set) {
            if (num != 0 && count[num] == 1) {
                return false; // Número repetido
            }
            count[num]++;
        }
        return true;
    }
}
