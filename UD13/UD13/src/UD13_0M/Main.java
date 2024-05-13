package UD13_0M;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    
    public Main() {
        super("Exemple de 'FocusListener'");
        
        // Creamos dos campos de texto
        JTextField campoTexto1 = new JTextField(20);
        JTextField campoTexto2 = new JTextField(20);
        
        // Creamos un botón
        JButton boton = new JButton("Limpiar campos de texto");
        
        // Asociamos un ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Este método se ejecuta cuando se presiona el botón
                campoTexto1.setText(""); // Limpiamos el contenido del campo de texto 1
                campoTexto2.setText(""); // Limpiamos el contenido del campo de texto 2
            }
        });


        // Creamos un FocusListener para los campos de texto
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Este método se ejecuta cuando un campo de texto obtiene el foco
                boton.setBackground(Color.RED); // Cambiamos el color del botón
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                // Este método se ejecuta cuando un campo de texto pierde el foco
                boton.setBackground(UIManager.getColor("Button.background")); // Restauramos el color original del botón
            }
        };
        
        // Asociamos el FocusListener a los campos de texto
        campoTexto1.addFocusListener(focusListener);
        campoTexto2.addFocusListener(focusListener);
        
        
        // Configuramos la ventana
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // A?adimos los componentes a la ventana
        add(campoTexto1);
        add(campoTexto2);
        add(boton);
        
        pack();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
