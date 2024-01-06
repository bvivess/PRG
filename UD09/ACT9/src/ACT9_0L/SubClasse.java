package ACT9_0L;

/**
 *
 * @author winadmin
 */
// Clase que extiende la clase abstracta e implementa la interfaz
class SubClasse extends ClasseAbstracta implements Interficie {
    
    // Implementació del mètode de la classe abstracta
    @Override
    public void metodeAbstracte() {
        System.out.println("Implementació del mètode de la classe abstracta en 'SubClasse'");
    }

    // Implementació del mètode de la Interfície
    @Override
    public void metodeDeInterficie() {
        System.out.println("Implementació del mètode de la Interfície en 'SubClasse'");
    }
}
