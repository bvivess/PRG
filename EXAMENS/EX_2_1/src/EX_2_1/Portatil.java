package EX_2_1;

/**
 * Comentari Javadoc
 * @author Administrador
 */

final class Portatil extends Mobil {
    private String pes;

    public Portatil(String marca, String model, float preuBase, String mida, String pes) {
        super(marca, model, preuBase, mida);
        this.pes = pes;
    }

    @Override
    public String toString() {
        return "Portatil: " + super.toString() + ",\n\tPes: " + pes;
    }
}

