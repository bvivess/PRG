package UD13_0A;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main2 {

    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Formulario Simple");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el JPanel que actuará como contenedor intermedio
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        frame.add(panel); // Agregar el panel al JFrame

        // Crear los componentes del formulario
        JLabel etiqueta1 = new JLabel("Campo 1:");
        JTextField campo1 = new JTextField();
        JLabel etiqueta2 = new JLabel("Campo 2:");
        JTextField campo2 = new JTextField();
        JLabel etiqueta3 = new JLabel("Campo 3:");
        JTextField campo3 = new JTextField();
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");

        // fegir els components al panel
        panel.add(etiqueta1);
        panel.add(campo1);
        panel.add(etiqueta2);
        panel.add(campo2);
        panel.add(etiqueta3);
        panel.add(campo3);
        panel.add(botonAceptar);
        panel.add(botonCancelar);

        // Agregar acción al botón "Aceptar"
        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para procesar los datos ingresados en los campos
                JOptionPane.showMessageDialog(null, "Datos aceptados");
            }
        });

        // Agregar acción al botón "Cancelar"
        botonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para cancelar la operación
                frame.dispose(); // Cierra el JFrame
            }
        });

        // Mostrar el JFrame
        frame.setVisible(true);
    }
}

