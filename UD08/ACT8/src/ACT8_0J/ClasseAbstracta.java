package ACT8_0J;

/**
 *
 * @author gt
 */
abstract class ClasseAbstracta {
    int a1;
    
    public ClasseAbstracta(int a1) {
        this.a1 = a1;
    }
 
    // Mètodo abstracte per ser implementat en SubClasse
    public abstract void metodeAbstracte();
    
    // Mètode concret en la classe abstracta
    public void metodeConcret() {
        System.out.println("MÈTODE CONCRET en Classe abstracta");
    }
}