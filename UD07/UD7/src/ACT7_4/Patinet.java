package ACT7_4;

final class Patinet extends VehicleElectric {
    public Patinet(String marca, String model, double preuBase, int potencia, int bateria) {
        super(marca, model, preuBase, potencia, bateria);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Preu total: " + this.calculaPreu();
    }
}