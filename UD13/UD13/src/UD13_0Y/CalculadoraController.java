package UD13_0Y;

class CalculadoraController {
    private CalculadoraModel modelo;
    private CalculadoraView vista;
    
    public CalculadoraController(CalculadoraModel modelo, CalculadoraView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void executaSuma() {
        int num1 = vista.LlegeixNumero("Ingrese el primer n�mero");
        int num2 = vista.LlegeixNumero("Ingrese el segundo n�mero");
        
        int resultado = this.modelo.ObteSuma(num1, num2);
        
        this.vista.mostraResultat(resultado);
    }
}