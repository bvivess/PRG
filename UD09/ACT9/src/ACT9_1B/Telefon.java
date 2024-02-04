package ACT9_1B;

import ACT9_1A.*;

/**
 *
 * @author winadmin
 */
public abstract class Telefon implements ValidadorDispositius, DispositiuElectronic {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat
    
    public abstract String getPatroCodiPin();
    public abstract String getPatroTeclat();
    public abstract String getPatroEmprempta();
    public abstract String getPatroRostre();
        
    public Telefon(String marca, Persona persona, boolean onOff) {
        // super(); // No cal ja que la interfície no té cap atribut
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }
    
    public boolean getOnOff() {
        return this.onOff;
    }
    
    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
    
    @Override
    public void on() {
        System.out.println("Telèfon encès");
        if (!this.onOff)
            this.onOff = true;
    }
    
    @Override
    public void off() {
        System.out.println("Telèfon apagat");
        if (this.onOff)
            this.onOff = false;
    }
    
    @Override
    public String toString() {
        return this.marca;
    }

    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validaPatrons(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
