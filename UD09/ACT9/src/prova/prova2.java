package prova;

/**
 *
 * @author winadmin
 */
public class prova2 {
    
}
interface MiInterfaz {
    default void metodoPorDefecto() {
        System.out.println("Implementación por defecto en la interfaz");
    }
}

class MiClase implements MiInterfaz {
    // La clase hereda automáticamente el método por defecto de la interfaz
}

class OtraClase implements MiInterfaz {
    // Se puede optar por sobrescribir el método por defecto si se desea
    @Override
    public void metodoPorDefecto() {
        System.out.println("Implementación personalizada en OtraClase");
    }
}

public class Main {
    public static void main(String[] args) {
        MiClase instancia1 = new MiClase();
        instancia1.metodoPorDefecto(); // Salida: Implementación por defecto en la interfaz

        OtraClase instancia2 = new OtraClase();
        instancia2.metodoPorDefecto(); // Salida: Implementación personalizada en OtraClase
    }
}
