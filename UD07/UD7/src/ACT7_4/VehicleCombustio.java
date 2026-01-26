package ACT7_4;

class VehicleCombustio extends VehicleMotor {
    private String tipusCombustible;

    public VehicleCombustio(String marca, String model, double preuBase, int potencia, String tipusCombustible) {
        super(marca, model, preuBase, potencia);
        setTipusCombustible(tipusCombustible);
    }

    @Override
    public double calculaPreu() {
        double total = super.calculaPreu();
        
        switch (tipusCombustible.toLowerCase()) {
            case "gasolina" -> total += 5000;
            case "diesel" -> total += 6000;
            case "hibrid" -> total += 7000;
        }
        return total;
    }

    public void setTipusCombustible(String tipusCombustible)  {
        if ((this.tipusCombustible.equals("gasolina")) ||
            (this.tipusCombustible.equals("diesel")) ||
            (this.tipusCombustible.equals("hibrid")))
            this.tipusCombustible = tipusCombustible;
        else
            throw new IllegalArgumentException("Tipus combustible incorrecte");
    }

    @Override
    public boolean equals(Object o) {
        VehicleCombustio vCombustio = (VehicleCombustio) o;
        return super.equals(vCombustio) &&
               this.tipusCombustible.equals(vCombustio.tipusCombustible);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Tipus Combustible: " + this.tipusCombustible;
    }
}


