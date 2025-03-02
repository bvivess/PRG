package ACT8_8;

// Classe Cotxe que hereta de Vehicle i implementa VehicleMotor
class Camio extends VehicleMotor {

    public Camio(String matricula, String marca, String model, int any, double potencia) {
        super(matricula, marca, model, any, potencia);
    }
    
    @Override
    public double calculaImposts() {
        return super.calculaImposts() + 5;
    }
    //@Override
    //public double calculaManteniment() {
    //    return super.calculaManteniment() + 500;
    //}
}
