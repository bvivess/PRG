package EX_UD04_II;



import java.util.ArrayList;
import java.util.Arrays;

public class EX_3_OK { 
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
        
        
        // Mostra les bombes i les persones generades aleatoriament
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
    
    private static void emplenaTauler(int[][] tauler, ArrayList<int[]> bombes, ArrayList<int[]>  persones) {
        // emplena les PERSONES
        for (int[] persona : persones) {  // per a cada persona
            // situar la persona en el tauler
            tauler[persona[0]][persona[1]] += SIMBOL_PERSONA;
        }
        
        // emplena les BOMBES
        for (int[] bomba : bombes) {  // per a cada bomba
            // situar la bomba en el tauler
            tauler[bomba[0]][bomba[1]] += SIMBOL_BOMBA;
        }
    }
    
    private static void comprovaTauler(ArrayList<int[]> bombes, ArrayList<int[]> persones) {
        // Per a cada persona, indicar quina bomba la mata
        
        boolean okPersona;
        
        for (int[] persona : persones) { // compara cada persona amb cada bomba
            okPersona = true;
            System.out.print("Comprovant " + persona[0] + "-" + persona[1] + " ") ;
            for (int[] bomba : bombes)
                if (Arrays.compare(persona, bomba) == 0) {  // també amb Arrays.equals
                    System.out.print("PERSONA NO SALVADA " + bomba[0] + "-" + bomba[1]);
                    okPersona = false;
                    break;
                }
            if (okPersona)
                System.out.print("PERSONA SALVADA ");
            
            System.out.println("");
        }
    }  
    
    private static ArrayList<int[]> generaElements(int totalElements) {
        ArrayList<int[]> elements = new ArrayList<>();
        int nElements = 0;
        
        // Genera les N posicions de cada Element
        while (nElements < totalElements) {
            // Crea posició  
            boolean okElement = true;
            int[] elementProva = UtilitatsArrays.generaArray(2,0, tauler.length-1); 
            
            // Comprova si ja existeix, posició a posició
            for (int j = 0; j < elements.size(); j++) {
                int[] element = elements.get(j);
                
                if (Arrays.equals(element, elementProva)) { // també amb Arrays.compare
                    okElement = false;
                    break;
                }
            }
            if (okElement) {
                elements.add(elementProva);
                nElements++;
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
