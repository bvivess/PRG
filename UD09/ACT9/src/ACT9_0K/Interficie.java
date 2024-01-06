package ACT9_0K;

/**
 *
 * @author gt
 */
interface Interficie {
    int a1 = 0;
    
    default void metodePerDefecte() {
        System.out.println("MÈTODE PER DEFECTE en la interfície.");
    }
    
    public void metodeAbstracte();
}
