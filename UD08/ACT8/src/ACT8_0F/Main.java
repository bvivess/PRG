package ACT8_0F;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        SubClasse instancia = new SubClasse();
        
        instancia.metodeAbstracteClasse(); // Implementaci� del m�tode abstracte de classe en 'SubClasse'
        instancia.metodeAbstracteInterficie(); // Implementaci�n del m�tode abstracte de interf�cie en 'SubClasse'
        //
        instancia.metodeConcret(); // Implementaci� concreta en la 'classe abstracta'
        instancia.metodePerDefecte();  // Implementaci� del m�tode per defecte en 'Interficie'
        //
        SubClasse.metodeEstatic();
        Interficie.metodeEstatic();
        //
        instancia.atributAbstracte = "Abstracte";  // o amb 'setter()'
        //instancia.atributInterficie = "InterficieX";  // no �s possible, �s final
        System.out.println(instancia.atributInterficie);
        System.out.println(instancia.atributAbstracte);
    }
}
