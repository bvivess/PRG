package UD13_0Z;

// Clase principal (Main)
public class Main {
    public static void main(String[] args) {
        CalculadoraModel modelo = new CalculadoraModel();
        CalculadoraView vista = new CalculadoraView();
        
        CalculadoraController controlador = new CalculadoraController(modelo, vista);
    }
}
