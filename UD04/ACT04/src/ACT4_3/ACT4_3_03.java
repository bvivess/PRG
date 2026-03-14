package ACT4_3;

public class ACT4_3_03 {
    public static void main(String[] args) {
        String[] opcions = {"Primera opcio", "Segona opcio", "Tercera opcio" };
        int opcio;
        
        do {
            opcio = UtilitatsConsola.gestionarMenu("Menu de proves", opcions, "Trii una opcio (0 per sortir): ");
            System.out.println(opcio);
        } while (opcio != 0);
        
        int nota = 8;
        


    }
}
