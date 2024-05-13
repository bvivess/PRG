/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EjemplosIniciales;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author atorre
 */

// 1) Creamos la clase ventana
public class EJ30EjemploInterfaz extends JFrame {

        public EJ30EjemploInterfaz () {
            initComponents();
        }

        private void initComponents() {
            // 2) Configuramos los parámetros de la ventana
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // 2) Crear los componentes
            JLabel etiqueta1 = new JLabel("Mensaje");
            JTextField campoDeTexto = new JTextField(20);
            JButton boton = new JButton("Aceptar");

            // 3) Crear un contenedor
            //JPanel panelDeContenido = new JPanel();
            JPanel panelDeContenido = (JPanel) this.getContentPane();

            // 4) Asociar los componentes al contenedor
            panelDeContenido.add(etiqueta1, BorderLayout.LINE_START);
            panelDeContenido.add(campoDeTexto, BorderLayout.LINE_END);
            panelDeContenido.add(boton, BorderLayout.PAGE_END);

            // 5) Asociar el contenedor a la ventana
            setContentPane(panelDeContenido);

            // 6) Hacer visible la ventana
            //setVisible(true);
        }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // 6) Hacer visible la ventana
                new EJ30EjemploInterfaz().setVisible(true);
            }
        });
    }

}
