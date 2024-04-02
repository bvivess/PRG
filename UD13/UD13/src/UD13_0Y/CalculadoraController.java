package UD13_0Y;

// Controlador (Controller): Actúa como intermediario entre el modelo y la vista. 
// Es responsable de interpretar las entradas del usuario y traducirlas en acciones que el modelo o la vista 
// deben realizar. También puede gestionar el flujo de la aplicación y la lógica de negocio.
class CalculadoraController {
    private CalculadoraModel modelo;
    private CalculadoraView vista;
    
    public CalculadoraController(CalculadoraModel modelo, CalculadoraView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void realizarSuma() {
        int num1 = vista.obtenerNumero("Ingrese el primer número");
        int num2 = vista.obtenerNumero("Ingrese el segundo número");
        
        int resultado = this.modelo.sumar(num1, num2);
        
        this.vista.mostrarResultado(resultado);
    }
}