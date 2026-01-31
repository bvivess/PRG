package EX_2_2;

public class EquipXarxa extends Dispositiu {
    private int nombrePorts;

    public EquipXarxa(String codiInventari, String nom, int consumBase, int nombrePorts) {
        super(codiInventari, nom, consumBase);
        this.nombrePorts = nombrePorts;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Nombre ports= " + this.nombrePorts +
               "\nTOTAL CONSUM: " + this.calculaConsum() + "W";
    }
    
    

}
