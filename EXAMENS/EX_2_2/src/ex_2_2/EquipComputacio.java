package ex_2_2;

import java.util.ArrayList;

public class EquipComputacio extends Dispositiu {
    private String processador;
    private int memoria;
    private ArrayList<Component> components = new ArrayList<>();

    public EquipComputacio(String codiInventari, String nom, int consumBase, String processador, int ram) {
        super(codiInventari, nom, consumBase);
        this.processador = processador;
        this.memoria = ram;
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
