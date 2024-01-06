package ACT9_0L;

/**
 *
 * @author winadmin
 */

// Clase abstracta
abstract class ClasseAbstracta {
    // Mètode abstracte que ha de ser implementat en la SubClasse
    public abstract void metodeAbstracte();
    
    // Mètode concreo en la classe abstracta
    public void metodoConcret() {
        System.out.println("Implementació del mètode concret en 'ClasseAbstracta'");
    }


}



