package UD13_0N;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    private JLabel etiqueta;
    private JButton boton;
    private JTextArea areaTexto;

    public Main() {
        super("Ventana de Eventos");
        
        // Crear la etiqueta
        etiqueta = new JLabel("Etiqueta");
        etiqueta.setPreferredSize(new Dimension(200, 300));
        etiqueta.setOpaque(true); // Hacer la etiqueta opaca para que el color de fondo sea visible
        etiqueta.setBackground(Color.YELLOW); // Color de fondo amarillo
        
        // Crear el botón
        boton = new JButton("Pincha aquí");
        
        // Crear el área de texto
        areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false); // Hacer que el área de texto no sea editable
        
        // Crear un ActionListener para el botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.append("Se ha hecho clic en el botón\n");
            }
        });
        
        // Crear un MouseListener para la etiqueta
        etiqueta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                areaTexto.append("El mouse ha entrado en la etiqueta\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                areaTexto.append("El mouse ha salido de la etiqueta\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // No se usa en este caso
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No se usa en este caso
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // No se usa en este caso
            }
        });
        
        // Configurar el dise?o de la ventana
        setLayout(new BorderLayout());
        
        // Agregar componentes a la ventana
        add(etiqueta, BorderLayout.WEST);
        add(boton, BorderLayout.CENTER);
        add(new JScrollPane(areaTexto), BorderLayout.SOUTH);
        
        // Configurar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400); // Tama?o suficiente para mostrar los tres controles
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
