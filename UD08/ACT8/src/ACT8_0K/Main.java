package ACT8_0K;

/**
 *
 * @author gt
 */
public class Main {
    public static void main(String[] args) {
        SubClasse1 subclasse1 = new SubClasse1(1, "aaa");
 
        
        subclasse1.metodePerDefecte(); // Cridada a 'm�todePerDefecte()' d''Interficie'
        subclasse1.metodeAbstracte();
        System.out.println(subclasse1.getB1());
        
        SubClasse2 subclasse2 = new SubClasse2();
        subclasse2.metodePerDefecte(); // Cridada a 'm�todePerDefecte()' de 'SubClasse2'
        subclasse2.metodeAbstracte();
    }
}