package examen;

import java.util.ArrayList;
import java.util.Arrays;

public class EX_1 { 
    static int NTAULER;
    static int NGLOBUS;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_GLOBUS = 1;
    static final int SIMBOL_GLOBUS_EXPLOTAT = 9;
    static int[][] tauler;
    static ArrayList<int[]> globus = new ArrayList<>();
    static ArrayList<int[]> globusExplotats = new ArrayList<>();
    static int fila;
    static int columna;
    
    public static void main(String[] args) {
        NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NGLOBUS = UtilitatsConsola.llegirSencer("Nombre de globus: ");
        
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        emplenaTauler(globus);
        explotaGlobusEnDiagonals(globus, globusExplotats);
        
        do {
            mostrarTauler(tauler, globus, globusExplotats);
            
            fila = UtilitatsConsola.llegirSencer("Nro. Fila: ");
            columna = UtilitatsConsola.llegirSencer("Nro. Columna: ");
            explotaGlobusEnFilaColumna(globus, globusExplotats, fila, columna);
            System.out.println("Queden " + globus.size() + " globus. ");
            System.out.println("S'han explotat " +  globusExplotats.size() + " globus.");
            
            mostrarTauler(tauler, globus, globusExplotats);
        } while (globus.size() != 0);  // mentre 'quedin globus'
    }
    
    public static void emplenaTauler(ArrayList<int[]> globus) {
        // Genera posició de cada globus 
        for (int i=0; i<NGLOBUS; i++) {
            afegeixGlobus(globus);
        }
    }
    
    public static void afegeixGlobus(ArrayList<int[]> globus) {
        int[] posNouGlobus;  // posició nou globus
        boolean okGlobus = true;

        do {
            posNouGlobus  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició del globus
            // Recorre 'globus' per veure que 'posGlobus' és correcta
            okGlobus = true;
            for (int[] pos : globus) {
                if (Arrays.equals(pos,posNouGlobus)) {
                    okGlobus = false;
                    break;
                }
            }
        } while (!okGlobus);
        
        // Afegeix globus
        globus.add(posNouGlobus);
    }
    
    public static void mostrarTauler(int[][] tauler, ArrayList<int[]> globus, ArrayList<int[]> globusExplotats) {
        String car="";
        
        netejaTauler(tauler);
        situaGlobus(tauler, globus, globusExplotats);
        
        // Coordenades 'X'
        System.out.print("   ");
        for (int i = 0; i < tauler.length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < tauler.length; i++) {
            // Coordenades 'Y'
            System.out.print(i + " |");
            for (int j = 0; j < tauler[i].length; j++) {
                switch (tauler[i][j]) {
                    case SIMBOL_BUIT -> car = "   ";
                    case SIMBOL_GLOBUS -> car = " * ";
                    case SIMBOL_GLOBUS_EXPLOTAT -> car = " O ";

                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
    public static void netejaTauler(int[][] tauler) {
        for (int i = 0; i < tauler.length; i++) 
            for (int j = 0; j < tauler[i].length; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }    

    public static void situaGlobus(int[][] tauler, ArrayList<int[]> globus, ArrayList<int[]> globusExplotats) {
        for (int[] pos : globus) {
            tauler[pos[0]][pos[1]] = SIMBOL_GLOBUS;
        }
        
        for (int[] pos : globusExplotats) {
            tauler[pos[0]][pos[1]] = SIMBOL_GLOBUS_EXPLOTAT;
        }
    }

    public static void explotaGlobusEnFilaColumna(ArrayList<int[]> globus, ArrayList<int[]> globusExplotats, int fila, int columna) {
        for (int i = globus.size() - 1; i >= 0; i--) {
            int[] pos = globus.get(i);
            if (pos[0] == fila || pos[1] == columna) {
                globus.remove(i);
                globusExplotats.add(pos);
            }
        }
    }
    
    public static void explotaGlobusEnDiagonals(ArrayList<int[]> globus, ArrayList<int[]> globusExplotats) {
        for (int i = globus.size() - 1; i >= 0; i--) {
            int[] pos = globus.get(i);
            if (pos[0] == pos[1] || pos[0]+pos[1] == NTAULER - 1) {
                System.out.println(pos[0] + "-" + pos[1]);
                globusExplotats.add(pos);
                globus.remove(i);
            }
        }
    }
}
