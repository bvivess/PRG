package ACT9_0L;

/**
 *
 * @author winadmin
 */

// Interfaz
interface Interficie {
    public abstract void metodeAbstracteDeInterficie();
    
    default void metodePerDefecte() {
        metodePrivat();
        System.out.println("Implementació del mètode per defecte en 'Interficie'");
    }
    
    public static void metodeEstatic() {
        System.out.println("Implementació d'un mètode estàtic2 en 'Interficie'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementació d'un mètode privat en mètode per defecte de 'Interficie'");
    }
}

