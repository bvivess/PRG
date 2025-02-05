package EX_2_1B;

/**
 * Comentari Javadoc
 * @author Administrador
 */

final class Tablet extends Mobil {

    public Tablet(String marca, String model, float preuBase, String mida) {
        super(marca, model, preuBase, mida);
    }

    @Override
    public String toString() {
        return "Tablet: " + super.toString();
    }
}

