package ACT7_4;

final class Cotxe extends VehicleCombustio {
    public Cotxe(String marca, String model, double preuBase, int potencia, String tipusCombustio) {
        super(marca, model, preuBase, potencia, tipusCombustio);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Preu total: " + this.calculaPreu();
    }
}


