package ACT8_0D;

/**
 *
 * @author gt
 */
class SubClasse1 extends ClasseAbstracta {
    private int b1;
    private String b2;
    
    public SubClasse1(int a1, int b1, String b2) {
        super(a1);
        this.b1 = b1;
        this.b2 = b2;
    }

    // Implementaci� del M�tode abstracte de la Classe abstracta  
    @Override
    public void metodeAbstracte() {
        System.out.println("M�TODE ABSTRACTE implementat en SubClasse1");
    }
    
    // Implementaci� del M�tode concret de la Classe abstracta  
    @Override
    public void metodeConcret() {
        System.out.println("M�TODE CONCRET implementat en SubClasse1");
    }
    
    //@Override
    public static void metodeEstatic() {
        System.out.println("M�TODE EST�TIC en SubClasse1");
    }

}