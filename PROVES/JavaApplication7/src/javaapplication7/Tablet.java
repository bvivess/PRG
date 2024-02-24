
package javaapplication7;

public class Tablet {

    private String marca;
    private Bateria bateria;

    public String getMarca() {
      return marca;
    }

    public void setMarca(String marca) {
      this.marca = marca;
    }

    public String getMarcaBateria() {
      return bateria.getMarca();
    }

    public void setMarcaBateria(String marca) {
      bateria.setMarca(marca);
    }
    
    public int getCapacidad() {
        return bateria.getCapacidad();
    }
    
    public void setCapacidad(int capacidad) {
        bateria.setCapacidad(capacidad);
        
    }

    public Tablet(String marcaTelefono, String marcaBateria, int capacidad) {
        this.marca = marcaTelefono;
        this.bateria = new Bateria(marcaBateria, capacidad);
    }
    
    public int duracionBateria() {
        return bateria.duracionBateria();
    }

}