package ACT8_0F;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        SubClasse subclasse = new SubClasse(1, "Subclasse");
        
        subclasse.metodeAbstracteClasse(); // Implementació del mètode abstracte de classe en 'SubClasse'
        subclasse.metodeAbstracteInterficie(); // Implementación del mètode abstracte de interfície en 'SubClasse'
        //
        subclasse.metodeConcret(); // Implementació concreta en la 'classe abstracta'
        subclasse.metodePerDefecte();  // Implementació del mètode per defecte en 'Interficie'
        //
        SubClasse.metodeEstatic();
        Interficie.metodeEstatic();
        //
        subclasse.setB2("Subclasse modificat");
        // subclasse.a1 = "InterficieX";  // no és possible, és final
        System.out.println(Interficie.a1);  // o també 'subclasse.a1'
        System.out.println(subclasse.a1);  // o també 'Interficie.a1'
        System.out.println(subclasse.getB1());
        System.out.println(subclasse.getB2());
    }
}
