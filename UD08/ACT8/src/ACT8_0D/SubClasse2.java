package ACT8_0D;

/**
 *
 * @author gt
 */
class SubClasse2 extends ClasseAbstracta {

    public SubClasse2(int a1) {
        super(a1);
    }
    
    // No es necesari sobre-escriure el m�tode concret de la 'clase abstracta'

    // Implementaci� del M�todo abstracte de la Classe abstracta  
    @Override
    public void metodeAbstracte() {
        System.out.println("M�TODE ABSTRACTE implementat en 'Classe2'");
    }
}
