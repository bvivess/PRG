package UD13_0Z;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controlador (Controller)
class CalculadoraController {
    private CalculadoraModel modelo;
    private CalculadoraView vista;

    public CalculadoraController(CalculadoraModel modelo, CalculadoraView vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.addSumarListener(new SumarListener());
    }

    class SumarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num1 = vista.getNum1();
            int num2 = vista.getNum2();
            int resultado = modelo.sumar(num1, num2);
            vista.setResultado(resultado);
        }
    }
}
