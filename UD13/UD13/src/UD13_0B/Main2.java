package UD13_0B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main2 {

    public static void main(String[] args) {
        // JFrame
        JFrame miJFrame = new JFrame("Formulari Simple");
        miJFrame.setSize(300, 200);
        miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el JPanel que actuar� como contenedor intermedio
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new GridLayout(4, 2));
        miJFrame.add(miJPanel); // Agregar el miJPanel al JFrame

        // Crear los componentes del formulario
        JLabel etiqueta1 = new JLabel("Campo 1:");
        JTextField campo1 = new JTextField();
        JLabel etiqueta2 = new JLabel("Campo 2:");
        JTextField campo2 = new JTextField();
        JLabel etiqueta3 = new JLabel("Campo 3:");
        JTextField campo3 = new JTextField();
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");

        // Afegir els components al miJPanel
        miJPanel.add(etiqueta1);
        miJPanel.add(campo1);
        miJPanel.add(etiqueta2);
        miJPanel.add(campo2);
        miJPanel.add(etiqueta3);
        miJPanel.add(campo3);
        miJPanel.add(botonAceptar);
        miJPanel.add(botonCancelar);

        // Agregar acci�n al bot�n "Aceptar"
        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes agregar la l�gica para procesar los datos ingresados en los campos
                JOptionPane.showMessageDialog(null, "Datos aceptados");
            }
        });

        // Agregar acci�n al bot�n "Cancelar"
        botonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes agregar la l�gica para cancelar la operaci�n
                miJFrame.dispose(); // Cierra el JFrame
            }
        });

        // Mostrar el JFrame
        miJFrame.setVisible(true);
    }
}

