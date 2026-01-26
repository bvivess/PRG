package ACT7_4;

final class Furgoneta extends VehicleCombustio {
    public Furgoneta(String marca, String model, double preuBase, int potencia, String tipusCombustio) {
        super(marca, model, preuBase, potencia, tipusCombustio);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Preu total: " + this.calculaPreu();
    }
}

