package UD13_0B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        // JFrame
        JFrame miJFrame = new JFrame("Formulari Simple");
        miJFrame.setSize(300, 200);
        miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new GridLayout(4, 2));
        

        // Crear los componentes del formulario
        JLabel miJLabel1 = new JLabel("Etiqueta1:");
        JTextField miTextField1 = new JTextField();
        JLabel miJLabel2 = new JLabel("Etiqueta2:");
        JTextField miTextField2 = new JTextField();
        JLabel miJLabel3 = new JLabel("Etiqueta3:");
        JTextField miTextField3 = new JTextField();
        JButton botonAceptar = new JButton("Acceptar");
        JButton botonCancelar = new JButton("Cancel�lar");

        // Afegir els components al miJPanel
        miJPanel.add(miJLabel1);
        miJPanel.add(miTextField1);
        miJPanel.add(miJLabel2);
        miJPanel.add(miTextField2);
        miJPanel.add(miJLabel3);
        miJPanel.add(miTextField3);
        miJPanel.add(botonAceptar);
        miJPanel.add(botonCancelar);
        miJFrame.add(miJPanel); // Agregar el miJPanel al JFrame

        // Agregar acci�n al bot�n "Aceptar"
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes agregar la l�gica para procesar los datos ingresados en los campos
                JOptionPane.showMessageDialog(null, "Dades Acceptades");
            }
        });
        
        botonAceptar.addFocusListener( new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Este m�todo se ejecuta cuando un campo de texto obtiene el foco
                botonAceptar.setBackground(Color.RED); // Cambiamos el color del bot�n
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                // Este m�todo se ejecuta cuando un campo de texto pierde el foco
                botonAceptar.setBackground(Color.YELLOW); // Restauramos el color original del bot�n
            }
        } );
        
        botonAceptar.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este m�todo se ejecuta cuando se hace clic en el bot�n
                botonAceptar.setBackground(Color.GREEN);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                // Este m�todo se ejecuta cuando se presiona un bot�n del mouse
                botonAceptar.setBackground(Color.BLACK);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // Este m�todo se ejecuta cuando se libera un bot�n del mouse
                botonAceptar.setBackground(Color.DARK_GRAY);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // Este m�todo se ejecuta cuando el mouse entra en el �rea del bot�n
                botonAceptar.setBackground(Color.CYAN);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // Este m�todo se ejecuta cuando el mouse sale del �rea del bot�n
            }
        } );

        // Agregar acci�n al bot�n "Cancelar"
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqu� puedes agregar la l�gica para cancelar la operaci�n
                miJFrame.dispose(); // Cierra el JFrame
            }
        });

        // Mostrar el JFrame
        miJFrame.setVisible(true);
    }
}

