package ACT9_0K;

/**
 *
 * @author gt
 */
public class Main {
    public static void main(String[] args) {
        SubClasse1 subclasse1 = new SubClasse1(1, "aaa");
 
        
        subclasse1.metodePerDefecte(); // Cridada a mètodePerDefecte Interficie
        System.out.println(subclasse1.getB1());
        SubClasse2 instancia2 = new SubClasse2();
        instancia2.metodePerDefecte(); // Cridada a mètodePerDefecte SubClasse2
    }
}