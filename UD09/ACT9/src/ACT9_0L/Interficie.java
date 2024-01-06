package ACT9_0L;

/**
 *
 * @author winadmin
 */

// Interfaz
interface Interficie {
    void metodeDeInterficie();
    
    default void metodePerDefecte() {
        System.out.println("Implementació del mètode per defecte en 'Interficie'");
    }
}

