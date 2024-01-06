package ACT9_0L;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        SubClasse instancia = new SubClasse();
        
        instancia.metodoConcret(); // Implementació concreta en la 'classe abstracta'
        instancia.metodeAbstracte(); // Implementación del método abstracto en 'SubClasse'
        instancia.metodeDeInterficie(); // Implementación del método de interfaz en 'SubClasse'
        instancia.metodePerDefecte();  // Implementació del mètode per defecte en 'Interficie'
    }
}
