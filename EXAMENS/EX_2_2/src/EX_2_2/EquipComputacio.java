package EX_2_2;

import java.util.ArrayList;

public class EquipComputacio extends Dispositiu {
    private String processador;
    private int memoria;
    private ArrayList<Component> components = new ArrayList<>();

    public EquipComputacio(String codiInventari, String nom, int consumBase, String processador, int memoria) {
        super(codiInventari, nom, consumBase);
        this.setProcessador(processador);
        this.setMemoria(memoria);
        this.components = new ArrayList<>();
    }

    public boolean afegeixComponent(Component c) {
        if (this.components.indexOf(c)==-1 )
            return components.add(c);
        return false;
    }
    
    public boolean eliminaComponent(String nom) {
        return components.remove(new Component(nom));
    }
    
    @Override
    public int calculaConsum() {
        int total = super.calculaConsum() + this.sumaConsumComponents();
        
        total += (this.processador.equals("i3") ? 10 : 
                  this.processador.equals("i5") ? 20 : 
                  this.processador.equals("i7") ? 30 : 40);  // "i9"

        total += (this.memoria ==  8  ? 10 : 
                  this.memoria == 16  ? 20 : 
                  this.memoria == 32  ? 30 : 40);  // 64
        
        return total;
    }
    
    protected int sumaConsumComponents() {
        int total = 0;
        for (Component c : this.components)
            total += c.getConsum();
        
        return total;
    }
    
    protected String getProcessador() {
        return processador;
    }

    public void setQuantitatRAM(int quantitatRAM) {
        this.memoria = quantitatRAM;
    }

    public void setProcessador(String processador) {
        switch (processador) {
            case "i3", "i5", "i7", "i9" -> this.processador = processador;
            default -> throw new IllegalArgumentException("Tipus de processador incorrecte");
        }
    }

    public void setMemoria(int memoria) {
        switch (memoria) {
            case 8, 16, 32, 64 -> this.memoria = memoria;
            default -> throw new IllegalArgumentException("Tipus combustible incorrecte");
        }
    }

    
    
    @Override
    public String toString() {
        String text = super.toString() + 
                      "Processador=" + this.processador + ", Memòria=" + this.memoria + "\n";
        text += "Components: \n";
        for (Component c : this.components)
            text += "\t" + c.toString() + "\n";
        
        text += "\nTOTAL CONSUM: " + this.calculaConsum() + "W";
        return text;
    }    

}
