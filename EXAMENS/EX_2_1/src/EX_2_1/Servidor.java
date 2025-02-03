package EX_2_1;

final class Servidor extends Sobretaula {
    public Servidor(String marca, String model, float preuDispositiu, String factorForma) {
        super(marca, model, preuDispositiu, factorForma);
    }

    @Override
    public String toString() {
        return "Servidor: " + super.toString();
    }
}