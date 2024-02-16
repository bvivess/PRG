package EX_UD04_II;

import java.util.ArrayList;
import java.util.Arrays;

public class EX_3 { 
    static int NTAULER;
    static int NBOMBES;
    static int NPERSONES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_PERSONA = 1;
    static final int SIMBOL_BOMBA = 9;
    static int[][] tauler;
    static ArrayList<int[]> bombes = new ArrayList<int[]>(); // posició (x,y) de cada bomba
    static ArrayList<int[]> persones = new  ArrayList<int[]>(); // posició (x,y) de cada persona

    public static void main(String[] args) {
        NTAULER = UtilitatsConsola.llegirSencer("Mida del TAULER: ");
        NBOMBES = UtilitatsConsola.llegirSencer("Nombre de BOMBES a generar: ");
        NPERSONES = UtilitatsConsola.llegirSencer("Nombre de PERSONES a generar: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        
        // NOTA: NO CAL MODIFICAR EL METODE 'main'
        
        // Genera les bombes i les persones
        bombes = generaElements(NBOMBES);
        persones = generaElements(NPERSONES);
        
        // Mostra les bombes i les persones generades aleatoriament
        mostraElements(bombes, persones);
        
        // Emplena el tauler amb els simbols de BOMBES i PERSONES
        emplenaTauler(tauler, bombes, persones);  // cal crear aquest metode com s'especifica a l'enunciat
        // Comprova quina PERSONA esta a sobre una BOMBA
        comprovaTauler(bombes, persones);  // cal crear aquest metode com s'especifica a l'enunciat

        // Mostra la matriu amb la puntuació 
        UtilitatsMatrius.mostrarMatriu(tauler);
    }
        
    // TO-DO code application logic here
    //   Crea el metode anterior de manera que faci allò que s'indica a l'enunciat
    
   
    private static ArrayList<int[]> generaElements(int totalElements) {
        ArrayList<int[]> elements = new ArrayList<>();
        int nElements = 0;
        
        // Genera les N posicions de cada torre
        while (nElements < totalElements) {
            // Crea posició  
            boolean okElement = true;
            int[] elementProva = UtilitatsArrays.generaArray(2,0, tauler.length-1); 
            
            // Comprova si ja existeix, posició a posició
            for (int j = 0; j < elements.size(); j++) {
                int[] torre = elements.get(j);
                
                if (Arrays.equals(torre, elementProva)) {
                    okElement = false;
                    break;
                }
            }
            if (okElement) {
                nElements++;
                elements.add(elementProva);
            }
        }
        
        return elements;
    }

    private static void mostraElements(ArrayList<int[]> bombes, ArrayList<int[]> persones) {
        // per a cada persona
        System.out.println("PERSONES");
        for (int[] persona : persones)
            UtilitatsArrays.mostraArray(persona);
        
        // per a cada bomba
        System.out.println("BOMBES");
        for (int[] bomba : bombes)
            UtilitatsArrays.mostraArray(bomba);
    }
       
}