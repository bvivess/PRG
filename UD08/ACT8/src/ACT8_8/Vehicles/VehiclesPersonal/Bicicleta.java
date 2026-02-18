package ACT8_8.Vehicles.VehiclesPersonal;

// Classe Bicicleta que només hereta de Vehicle
public final class Bicicleta extends VehiclePersonal {

    public Bicicleta(String matricula, String marca, String model, int any, boolean esElectrica) {
        super(matricula, marca, model, any, esElectrica);
    }
    
    //@Override
    //public double calculaImposts() {
    //    return super.calculaImposts() + 10;
    //}
}
