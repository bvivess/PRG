package ACT8_0J;

/**
 *
 * @author gt
 */
class SubClasse2 extends ClasseAbstracta {

    public SubClasse2(int a1) {
        super(a1);
    }
    
    // No es necesario sobre-escribir el m�todo concreto de la clase abstracta

    // Implementaci� del M�todo abstracte de la Classe abstracta  
    @Override
    public void metodeAbstracte() {
        System.out.println("M�TODE ABSTRACTE implementat en SubClasse2");
    }
}
