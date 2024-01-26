package ACT9_0K;

/**
 *
 * @author gt
 */
interface Interficie {
    int a1 = 0;
    
    public void metodeAbstracte();
    
    default void metodePerDefecte() {
        System.out.println("MÈTODE PER DEFECTE en la interfície.");
    }
}
