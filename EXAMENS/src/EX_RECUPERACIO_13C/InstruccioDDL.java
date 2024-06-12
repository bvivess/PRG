package EX_RECUPERACIO_13C;

public class InstruccioDDL {
    private int ordre;
    private String texte;

    public InstruccioDDL(int ordre, String texte) {
        this.ordre = ordre;
        this.texte = texte;
    }

    @Override
    public String toString() {
        return "InstruccioDDL{" + "ordre=" + ordre + ", texte=" + texte + '}';
    }

    public String getTexte() {
        return texte;
    }
    
}
