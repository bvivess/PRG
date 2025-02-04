package EX_2_1;

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