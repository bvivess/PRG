package ACT8_0D;

/**
 *
 * @author gt
 */
public class Main {
    public static void main(String[] args) {
        SubClasse1 subClasse1 = new SubClasse1(1,2,"aaa");
        SubClasse2 subClasse2 = new SubClasse2(1);

        subClasse1.metodeConcret();  // Cridada a m�todeConcret()
        subClasse1.metodeAbstracte(); // Cridada a m�todeAbstracte()  
        subClasse1.metodeEstatic();
        subClasse2.metodeConcret();  // Cridada a m�todeConcret()
        subClasse2.metodeAbstracte(); // Cridada a m�todeAbstracte()
    }
}