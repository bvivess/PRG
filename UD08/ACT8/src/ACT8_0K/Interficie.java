package ACT8_0K;

/**
 *
 * @author gt
 */
interface Interficie {
    int a1 = 0;
    
    public void metodeAbstracte();
    
    default void metodePerDefecte() {
        System.out.println("M�TODE PER DEFECTE en la interf�cie.");
    }
}
