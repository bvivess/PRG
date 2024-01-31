package ACT9_0L;

/**
 *
 * @author winadmin
 */

// Interfaz
interface Interficie {
    void metodeAbstracteDeInterficie();
    
    default void metodePerDefecte() {
        metodePrivat();
        System.out.println("Implementació del mètode per defecte en 'Interficie'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementació d'un mètode privat en 'Interficie'");
    }
}

