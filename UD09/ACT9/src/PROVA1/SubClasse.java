package PROVA1;

/**
 *
 * @author gt
 */
class SubClasse extends ClasseAbstracta {
    // No es necesario sobre-escribir el método concreto de la clase abstracta

    // Se implementa el método abstracto de la clase abstracta
    @Override
    public void metodoAbstracto() {
        System.out.println("Implementación del método abstracto en la subclase");
    }
}
