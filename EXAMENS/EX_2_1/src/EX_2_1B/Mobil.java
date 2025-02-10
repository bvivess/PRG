package EX_2_1B;

/**
 * Comentari Javadoc
 * @author Administrador
 */

abstract class Mobil extends Dispositiu {
    private String mida;

    public Mobil(String marca, String model, float preuBase, String mida) {
        super(marca, model, preuBase);
        setMida(mida);
    }
    
    /**
     * CalculaPreu per a Mobil
     * @return preuBase + preu segons 'mida'
     */
    
    public float calculaPreu() {
        float preuTotal=super.getPreuBase();
        
        preuTotal += (this.mida.equals("5'") ? 5 : 
                        this.mida.equals("10'") ? 10 :
                        this.mida.equals("12'") ? 12 :
                        this.mida.equals("14'") ? 14 : 17);

        return preuTotal;
    }

    public void setMida(String mida) {
        if (mida.equals("5'") || mida.equals("10'") || mida.equals("12'") || mida.equals("14'") || mida.equals("17'"))
            this.mida = mida;
        else {
            this.mida = "";
            System.err.println("Error, 'mida' incorrecte");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Mobil m = (Mobil) obj;
        return super.equals(obj) && this.mida.equals(m.mida);
    }

    @Override
    public String toString() {
        return super.toString() + ", mida:" + this.mida;
    }

}
