package EX_2_1B;

/**
 * Comentari Javadoc
 * @author Administrador
 */

final class Escriptori extends Sobretaula {
    public Escriptori(String marca, String model, float preuDispositiu, String factorForma) {
        super(marca, model, preuDispositiu, factorForma);
    }

    @Override
    public String toString() {
        return "Escriptori: " + super.toString();
    }
}
