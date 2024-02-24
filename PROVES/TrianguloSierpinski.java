public class TrianguloSierpinski  {

    public static void main(String[] args) {
        dibujarTrianguloSierpinski(4);
    }

    private static void dibujarTrianguloSierpinski(int nivel) {
        int altura = calcularAltura(nivel);

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < 2 * altura - 1; j++) {
                if (esParteTriangulo(i, j, altura)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int calcularAltura(int nivel) {
        return (int) Math.pow(2, nivel - 1);
    }

    private static boolean esParteTriangulo(int fila, int columna, int altura) {
        int inicio = altura - 1 - fila;
        int fin = altura - 1 + fila;

        return columna >= inicio && columna <= fin;
    }
}
