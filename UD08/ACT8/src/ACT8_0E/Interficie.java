package ACT8_0E;

/**
 *
 * @author gt
 */
interface Interficie {
    int a1 = 0;
    
    abstract public void metodeAbstracte();
    
    default void metodePerDefecte() {
        System.out.println("M�TODE PER DEFECTE en la interf�cie.");
    }
}
