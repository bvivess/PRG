package ACT9_0L;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        SubClasse instancia = new SubClasse();
        
        instancia.metodeAbstracteDeClasse(); // Implementació del mètode abstracte de classe en 'SubClasse'
        instancia.metodeAbstracteDeInterficie(); // Implementación del mètode abstracte de interfície en 'SubClasse'
        //
        SubClasse.metodeEstatic();
        Interficie.metodeEstatic();
        instancia.metodeConcret(); // Implementació concreta en la 'classe abstracta'
        instancia.metodePerDefecte();  // Implementació del mètode per defecte en 'Interficie'
    }
}
