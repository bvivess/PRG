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
        

        // Components
        JLabel miJLabel1 = new JLabel("Etiqueta1:");
        JTextField miTextField1 = new JTextField();
        JLabel miJLabel2 = new JLabel("Etiqueta2:");
        JTextField miTextField2 = new JTextField();
        JLabel miJLabel3 = new JLabel("Etiqueta3:");
        JTextField miTextField3 = new JTextField();
        JButton botoAcceptar = new JButton("Acceptar");
        JButton botoCancelar = new JButton("Cancel·lar");

        // Afegir els components-JPanel i JPanel-JFrame
        miJPanel.add(miJLabel1);
        miJPanel.add(miTextField1);
        miJPanel.add(miJLabel2);
        miJPanel.add(miTextField2);
        miJPanel.add(miJLabel3);
        miJPanel.add(miTextField3);
        miJPanel.add(botoAcceptar);
        miJPanel.add(botoCancelar);
        miJFrame.add(miJPanel); // Agregar el JPanel al JFrame

        // Agregar acció al botó "Acceptar"
        botoAcceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para procesar los datos ingresados en los campos
                JOptionPane.showMessageDialog(null, "Dades Acceptades");
            }
        });
        
        botoAcceptar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Este método se ejecuta cuando un campo de texto obtiene el foco
                botoAcceptar.setBackground(Color.RED); // Cambiamos el color del botón
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                // Este método se ejecuta cuando un campo de texto pierde el foco
                botoAcceptar.setBackground(Color.YELLOW); // Restauramos el color original del botón
            }
        } );
        
        botoAcceptar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este método se ejecuta cuando se hace clic en el botón
                botoAcceptar.setBackground(Color.GREEN);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                // Este método se ejecuta cuando se presiona un botón del mouse
                botoAcceptar.setBackground(Color.BLACK);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // Este método se ejecuta cuando se libera un botón del mouse
                botoAcceptar.setBackground(Color.DARK_GRAY);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // Este método se ejecuta cuando el mouse entra en el área del botón
                botoAcceptar.setBackground(Color.CYAN);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se ejecuta cuando el mouse sale del área del botón
                botoAcceptar.setBackground(Color.BLACK);
            }
        } );

        // Agregar acción al botón "Cancelar"
        botoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para cancelar la operación
                miJFrame.dispose(); // Cierra el JFrame
            }
        });

        // Mostrar el JFrame
        miJFrame.setVisible(true);
    }
}

