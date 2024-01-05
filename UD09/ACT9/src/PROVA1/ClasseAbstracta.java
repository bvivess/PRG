package PROVA1;

/**
 *
 * @author gt
 */
abstract class ClasseAbstracta {
    // Método concreto en la clase abstracta
    public void metodoConcreto() {
        System.out.println("Implementación concreta en la clase abstracta");
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract void metodoAbstracto();
}