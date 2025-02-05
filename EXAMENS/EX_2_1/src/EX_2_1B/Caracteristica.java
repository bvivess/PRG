package EX_2_1B;

/**
 * Comentari Javadoc
 * @author Administrador
 */

class Caracteristica {
    private String caracteristica;

    public Caracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "Caracteristica: " + this.caracteristica;
    }
}