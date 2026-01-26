package ACT7_4;

class VehicleMotor extends Vehicle {
    private int potencia;


    public VehicleMotor(String marca, String model, double preuBase, int potencia) {
        super(marca, model, preuBase);
        this.potencia = potencia;
    }
    
    @Override
    public double calculaPreu() {
        double total = super.calculaPreu();
        
        return total + 
            ( this.potencia < 100 ? 500 : 1000 );
    }
    
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        VehicleMotor vm = (VehicleMotor) o;
        return potencia == vm.potencia;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Potència: " + this.potencia;
    }
}