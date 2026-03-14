package ACT8_0F;

/**
 *
 * @author winadmin
 */

// Clase abstracta
abstract class ClasseAbstracta {
    private int b1;
    private String b2;

    public ClasseAbstracta(int b1, String b2) {
        this.b1 = b1;
        this.b2 = b2;
    }
    
    // Mètode abstracte que ha de ser implementat en la SubClasse
    public abstract void metodeAbstracteClasse();
    
    // Mètode concret en la classe abstracta
    public void metodeConcret() {
        metodePrivat();
        System.out.println("Implementació del mètode concret en 'ClasseAbstracta'");
    }
    
    public static void metodeEstatic() {
        System.out.println("Implementació d'un mètode estàtic1 en 'ClasseAbstracta'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementació d'un mètode privat en mètode concret de 'ClasseAbstracta'");
    }

    public int getB1() {
        return b1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

}



