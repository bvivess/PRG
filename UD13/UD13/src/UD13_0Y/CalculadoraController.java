package UD13_0Y;

// Controller: aplica la lògica de l'aplicació. Coordina la vista i el model.


class CalculadoraController {
    private CalculadoraModel model;
    private CalculadoraView vista;
    
    public CalculadoraController(CalculadoraModel model, CalculadoraView vista) {
        this.model = model;
        this.vista = vista;
    }
    
    public void executaSuma() {
        int num1 = this.vista.LlegeixNumero("Introdueixi el primer número: ");
        int num2 = this.vista.LlegeixNumero("Introdueixi el segon número: ");
        
        int resultat = this.model.ObteSuma(num1, num2);
        
        this.vista.mostraResultat(resultat);
    }
}