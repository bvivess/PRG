package ACT8_0F;

/**
 *
 * @author winadmin
 */

// Interfaz
interface Interficie {
    public final String atributInterficie="Interficie";  // 'final' no �s obligat�ria
    
    
    public abstract void metodeAbstracteInterficie();  // 'abstract' no �s obligat�ria
    
    default void metodePerDefecte() {
        metodePrivat();
        System.out.println("Implementaci� del m�tode per defecte en 'Interficie'");
    }
    
    public static void metodeEstatic() {
        System.out.println("Implementaci� d'un m�tode est�tic2 en 'Interficie'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementaci� d'un m�tode privat en m�tode per defecte de 'Interficie'");
    }
}

