package ACT8_0J;

/**
 *
 * @author gt
 */
public class Main {
    public static void main(String[] args) {
        SubClasse1 instancia1 = new SubClasse1(1,2,"aaa");
        SubClasse2 instancia2 = new SubClasse2(1);

        instancia1.metodeConcret();  // Cridada a mètodeConcret()
        instancia1.metodeAbstracte(); // Cridada a mètodeAbstracte()        
        instancia2.metodeConcret();  // Cridada a mètodeConcret()
        instancia2.metodeAbstracte(); // Cridada a mètodeAbstracte()
    }
}