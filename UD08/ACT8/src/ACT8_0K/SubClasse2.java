package ACT8_0K;

/**
 *
 * @author gt
 */
class SubClasse2 implements Interficie {
    
    // La SubClasse2 sobreescriu el metodePerDefecte() de la interfície
    @Override
    public void metodePerDefecte() {
        System.out.println("MÈTODE PER DEFECTE en SubClasse2." + a1);
    }
    
    @Override
    public void metodeAbstracte() {
        System.out.println("MÈTODE ABSTRACTE en SubClasse2." + a1);
    }
}

