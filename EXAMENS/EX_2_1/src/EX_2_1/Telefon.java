package EX_2_1;

/**
 * Comentari Javadoc
 * @author Administrador
 */

final class Telefon extends Mobil {

    public Telefon(String marca, String model, float preuDispositiu, String mida) {
        super(marca, model, preuDispositiu, mida);
    }

    @Override
    public String toString() {
        return "Telefon: " + super.toString();
    }
}