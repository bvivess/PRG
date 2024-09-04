package ACT8_0L;

/**
 *
 * @author winadmin
 */
// Clase que extiende la clase abstracta e implementa la interfaz
class SubClasse extends ClasseAbstracta implements Interficie {
    
    // Implementaci� del m�tode de la classe abstracta
    @Override
    public void metodeAbstracteDeClasse() {
        metodePrivat();
        System.out.println("Implementaci� del m�tode de la classe abstracta en 'SubClasse'");
    }

    // Implementaci� del m�tode de la Interf�cie
    @Override
    public void metodeAbstracteDeInterficie() {
        metodePrivat();
        System.out.println("Implementaci� del m�tode de la Interf�cie en 'SubClasse'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementaci� d'un m�tode privat en metodes sobreescrits de 'Subclasse'");
    }
}
