package UD13_0M;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    
    public Main() {
        super("Exemple de 'FocusListener'");
        
        // Creamos dos campos de texto
        JTextField texte1 = new JTextField(20);
        JTextField texte2 = new JTextField(20);
        
        // Creamos un botón
        JButton boto = new JButton("Limpiar campos de texto");
        
        // Associar un 'ActionListener' al 'boto'
        boto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // S'executa al presionar el botó
                texte1.setText(""); // Es neteja de 'texte1'
                texte2.setText(""); // Es neteja de 'texte2'
            }
        });


        // Es crea un'focusListener'
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                boto.setBackground(Color.RED); // Cambiamos el color del botón
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                boto.setBackground(UIManager.getColor("Button.background")); // Restaurar el color original del botó
            }
        };
        
        // Associar un 'focusListener' a cada camp 'textx'
        texte1.addFocusListener(focusListener);
        texte2.addFocusListener(focusListener);
        
        
        // Configuramos la ventana
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // A?adimos los componentes a la ventana
        add(texte1);
        add(texte2);
        add(boto);
        
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
