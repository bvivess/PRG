package ACT8_8;

// Interfície per als vehicles de motor
abstract class VehiclePersonal extends Vehicle {
    private boolean esElectric;
    
    public VehiclePersonal(String matricula, String marca, String model, int any, boolean esElectric) {
        super(matricula, marca, model, any);
        this.esElectric = esElectric;
    }
    
    @Override
    public double calculaImpost() {
        return (this.esElectric ? 50 : 0);
    }
    
    @Override
    public double calculaManteniment() {
        double total = this.potencia * 0.20;
        
        if (this instanceof Camio)
            total += 500;
        else if (this instanceof Cotxe)
            total += 100;
        else if (this instanceof Moto)
            total += 50;
        return total;
    }

}