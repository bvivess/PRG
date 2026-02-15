package ACT8_8.Vehicles.VehiclesMotor;

// Classe Cotxe que hereta de Vehicle i implementa VehicleMotor
public class Moto extends VehicleMotor {

    public Moto(String matricula, String marca, String model, int any, double potencia) {
        super(matricula, marca, model, any, potencia);
    }
    
    //@Override
    //public double calculaManteniment() {
    //    return super.calculaManteniment() + 50;
    //}
}
