package ACT8_0E;

/**
 *
 * @author gt
 */
class Classe2 implements Interficie {
    
    @Override
    public void metodeAbstracte() {
        System.out.println("M�TODE ABSTRACTE en Classe2: " + a1);
    }
    
    // La Classe2 sobreescriu el metodePerDefecte() de la interf�cie
    @Override
    public void metodePerDefecte() {
        System.out.println("M�TODE PER DEFECTE en Classe2: " + a1);
    }
    

}

