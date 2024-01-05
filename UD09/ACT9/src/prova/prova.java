package prova;

/**
 *
 * @author winadmin
 */
public class prova {
    
}

abstract class ClaseAbstracta {
    // Método concreto en la clase abstracta
    public void metodoConcreto() {
        System.out.println("Implementación concreta en la clase abstracta");
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract void metodoAbstracto();
}

class Subclase extends ClaseAbstracta {
    // No es necesario sobre-escribir el método concreto de la clase abstracta

    // Se implementa el método abstracto de la clase abstracta
    @Override
    public void metodoAbstracto() {
        System.out.println("Implementación del método abstracto en la subclase");
    }
}

public class Main {
    public static void main(String[] args) {
        Subclase instancia = new Subclase();
        instancia.metodoConcreto(); // Salida: Implementación concreta en la clase abstracta
        instancia.metodoAbstracto(); // Salida: Implementación del método abstracto en la subclase
    }
}
