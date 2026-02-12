package ACT8_0F;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        SubClasse subclasse = new SubClasse();
        
        subclasse.metodeAbstracteClasse(); // Implementació del mètode abstracte de classe en 'SubClasse'
        subclasse.metodeAbstracteInterficie(); // Implementación del mètode abstracte de interfície en 'SubClasse'
        //
        subclasse.metodeConcret(); // Implementació concreta en la 'classe abstracta'
        subclasse.metodePerDefecte();  // Implementació del mètode per defecte en 'Interficie'
        //
        SubClasse.metodeEstatic();
        Interficie.metodeEstatic();
        //
        subclasse.atributAbstracte = "Abstracte";  // o amb 'setter()'
        // subclasse.atributInterficie = "InterficieX";  // no és possible, és final
        System.out.println(subclasse.atributInterficie);
        System.out.println(subclasse.atributAbstracte);
    }
}
