package ACT10_8;

import java.util.List;

public class Tauler {
    private int mida;

    public Tauler(int mida) {
        this.mida = mida;
    }

    public int getMida() {
        return mida;
    }

    public void mostrarTauler(List<Posicio> cuc, List<Posicio> fulles) {
        char[][] matriu = new char[this.mida][this.mida];

        inicialitzar(matriu);
        pintarFulles(matriu, fulles);
        pintarCuc(matriu, cuc);
        imprimir(matriu);
    }

    private void inicialitzar(char[][] matriu) {
        for (int i = 0; i < mida; i++)
            for (int j = 0; j < mida; j++)
                matriu[i][j] = ' ';
    }

    private void pintarFulles(char[][] matriu, List<Posicio> fulles) {
        for (Posicio f : fulles) {
            Posicio p = f;

            matriu[p.getFila()][p.getColumna()] = '*';
        }
    }

    private void pintarCuc(char[][] matriu, List<Posicio> cuc) {
        int index = 0;

        for (Posicio p : cuc) {
            if (index == cuc.size() - 1)
                matriu[p.getFila()][p.getColumna()] = 'O';
            else
                matriu[p.getFila()][p.getColumna()] = '.';

            index++;
        }
    }

    private void imprimir(char[][] matriu) {
        for (int i = 0; i < mida; i++) {

            System.out.print("|");

            for (int j = 0; j < mida; j++) {
                System.out.print(" " + matriu[i][j] + " ");
            }

            System.out.println("|");
        }
    }
}