package PROVA1;

/**
 *
 * @author gt
 */
public class Main {
    public static void main(String[] args) {
        SubClasse instancia = new SubClasse();
        
        instancia.metodoConcreto(); // Salida: Implementación concreta en la clase abstracta
        instancia.metodoAbstracto(); // Salida: Implementación del método abstracto en la subclase
    }
}