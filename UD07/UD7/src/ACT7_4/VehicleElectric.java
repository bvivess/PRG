package ACT7_4;

class VehicleElectric extends VehicleMotor {
    private int capacitatBateria;

    public VehicleElectric(String marca, String model, double preuBase, int potencia, int capacitatBateria) {
        super(marca, model, preuBase, potencia);
        setCapacitatBateria(capacitatBateria);
    }

    @Override
    public double calculaPreu() {
        double total = super.calculaPreu();
        
        return total + 
            ( this.capacitatBateria == 40 ? 8000 :
              this.capacitatBateria == 60 ? 12000 :
              this.capacitatBateria == 80 ? 16000 :
              0 );
    }
    
    public void setCapacitatBateria(int capacitatBateria)  {
        if ((this.capacitatBateria == 40) ||
            (this.capacitatBateria == 60) ||
            (this.capacitatBateria == 80))
            this.capacitatBateria = capacitatBateria;
        else
            throw new IllegalArgumentException("Capacitat bateria incorrecte");
    }

    @Override
    public boolean equals(Object o) {
        VehicleElectric vElectric = (VehicleElectric) o;
        return super.equals(vElectric) &&
               capacitatBateria == vElectric.capacitatBateria;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Bateria: " + this.capacitatBateria;
    }
}
