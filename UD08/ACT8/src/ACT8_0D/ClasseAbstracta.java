package ACT8_0D;

/**
 *
 * @author gt
 */
abstract class ClasseAbstracta {
    protected int a1;
    
    public ClasseAbstracta(int a1) {
        this.a1 = a1;
    }
 
    // M�todo abstracte per ser implementat en SubClasse
    public abstract void metodeAbstracte();
    
    // M�tode concret en la classe abstracta
    public void metodeConcret() {
        System.out.println("M�TODE CONCRET en Classe abstracta");
    }
    
    public static void metodeEstatic() {
        System.out.println("M�TODE EST�TIC en Classe abstracta");
    }
}