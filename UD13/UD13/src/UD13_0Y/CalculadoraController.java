package UD13_0Y;

// Controller: aplica la l�gica de l'aplicaci�. Coordina la vista i el model.


class CalculadoraController {
    private CalculadoraModel model;
    private CalculadoraView vista;
    
    public CalculadoraController(CalculadoraModel model, CalculadoraView vista) {
        this.model = model;
        this.vista = vista;
    }
    
    public void executaSuma() {
        int num1 = this.vista.LlegeixNumero("Introdueixi el primer n�mero: ");
        int num2 = this.vista.LlegeixNumero("Introdueixi el segon n�mero: ");
        
        int resultat = this.model.ObteSuma(num1, num2);
        
        this.vista.mostraResultat(resultat);
    }
}