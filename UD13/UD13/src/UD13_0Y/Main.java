package UD13_0Y;

// Clase principal (Main)
class Main {
    public static void main(String[] args) {
        CalculadoraModel modelo = new CalculadoraModel();
        CalculadoraView vista = new CalculadoraView();
        
        CalculadoraController controlador = new CalculadoraController(modelo, vista);
        
        controlador.realizarSuma();
    }
}


