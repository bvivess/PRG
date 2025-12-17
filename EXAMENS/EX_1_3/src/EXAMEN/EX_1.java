package EXAMEN;

import java.util.ArrayList;
import java.util.Arrays;

public class EX_1 { 
    static int NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
    static int NALIENS = UtilitatsConsola.llegirSencer("Nombre de Aliens: ");
    static int FILA_INICIAL_ALIENS = 4;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_NAU = 1;
    static final int SIMBOL_ALIEN = 9;

    public static void main(String[] args) {
        int[][] tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        ArrayList<int[]> aliens = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> posició dels aliens
        int[] nau = new int[2];  // [a,b] és la posició de la nau en el tauler 
        int accio;  // Acció a realitzar
        
        inicialitzaJoc(tauler, nau, aliens);
        
        do {
            mostrarTauler(tauler, nau, aliens);
            accio = UtilitatsConsola.llegirSencer("PUNTUACIÓ: " + (NALIENS - aliens.size()) + ", 4:ESQUERRA, 6:DRETA, 9: DISPAR, 0:SORTIR: ");

            if (executaAccio(tauler, nau, aliens, accio)) {
                System.out.println("Seguim");
                if (aliens.isEmpty()) {
                    System.out.println("YOU WIN !!");
                    accio = 0;
                }
            } else {
                mostrarTauler(tauler, nau, aliens);
                System.out.println("PUNTUACIÓ: " + (NALIENS - aliens.size()) + " YOU LOSE !!");
                accio = 0;
            }
        } while (accio != 0);
    }
    
    public static void inicialitzaJoc(int[][] tauler, int[] nau, ArrayList<int[]> aliens) {
        // Genera posició Inicial nau
        int[] pos = UtilitatsArrays.generaArray(2, 0, NTAULER-1);
        nau[0] = 0;
        nau[1] = pos[1];
      
        // Genera posició de cada alien 
        for (int i=0; i < NALIENS; i++)
            afegeixUnAlien(tauler, nau, aliens);
    }
    
    public static void afegeixUnAlien(int[][] tauler, int[] nau, ArrayList<int[]> aliens) {
        int[] pos;  // posicio 
        boolean ok;

        // Recorre 'aliens' per veure que 'pos' és correcta
        do {
            ok = true;
            pos  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició de la fulla
            if (pos[0] <= FILA_INICIAL_ALIENS)
                ok = false;
            else
            // Recorre 'aliens' per veure que 'pos' és correcta
                for (int[] p : aliens) {
                    if (Arrays.equals(p, pos)){
                        ok = false;
                        break;
                    }
                }
        } while (!ok);
        
        // Afegeix alien
        aliens.add(pos);
    }
    
    public static boolean executaAccio(int[][] tauler, int[] nau, ArrayList<int[]> aliens, int accio) { 
        int[] posNauEnemiga;
        
        switch (accio) {
            case 4 -> // ESQ
                nau[1] = (nau[1] == 0 ? NTAULER-1 : --nau[1]); 
            case 6  -> // DRETA
                nau[1] = (nau[1] == NTAULER-1 ? 0 : ++nau[1]); 
            case 9 -> { // DISPARAR
                // Cada dispar menja alien ?
                for (int i=1; i < NTAULER; i++) {
                    int[] posDispar = { i, nau[1] };
                    for (int j=0; j < aliens.size(); j++) {
                        posNauEnemiga = aliens.get(j);
                        if (Arrays.equals(posNauEnemiga, posDispar)) 
                            aliens.remove(j);
                    }
                }
                
                // Desprès de cada dispar, cal baixar cada alien en una fila
                for (int[] a : aliens)
                    if (--a[0] == 0) {
                        return false;
                }
            }
        }
        return true;
    }
 
    public static void mostrarTauler(int[][] tauler, int[] nau, ArrayList<int[]> nausEnemigues) {
        String car="";
        
        netejaTauler(tauler);
        situaNau(tauler, nau);
        situaNausEnemigues(tauler, nausEnemigues);
        
        for (int i = 0; i < NTAULER ; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                switch (tauler[i][j]) {
                    case SIMBOL_BUIT -> car = "   ";
                    case SIMBOL_ALIEN -> car = " * ";
                    case SIMBOL_NAU -> car = " O ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
    
     public static void netejaTauler(int[][] tauler){
        for (int i = 0; i < NTAULER; i++) 
            for (int j = 0; j < NTAULER; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }    

    public static void situaNau(int[][] tauler, int[] nau){
        tauler[nau[0]][nau[1]] = SIMBOL_NAU;
    }
    
    public static void situaNausEnemigues(int[][] tauler, ArrayList<int[]> neusEnemigues){
        for (int[] pos : neusEnemigues) {
            tauler[pos[0]][pos[1]] = SIMBOL_ALIEN;
        }
    }   
}
