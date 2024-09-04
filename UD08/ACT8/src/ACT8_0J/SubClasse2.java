package ACT8_0J;

/**
 *
 * @author gt
 */
class SubClasse2 extends ClasseAbstracta {

    public SubClasse2(int a1) {
        super(a1);
    }
    
    // No es necesario sobre-escribir el método concreto de la clase abstracta

    // Implementació del Mètodo abstracte de la Classe abstracta  
    @Override
    public void metodeAbstracte() {
        System.out.println("MÈTODE ABSTRACTE implementat en SubClasse2");
    }
}
