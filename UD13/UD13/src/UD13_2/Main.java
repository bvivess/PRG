package UD13_2;

import javax.swing.*;

public class Main extends JFrame {
    
    public static void main(String[] args) {
        // 1- CONTENIDOR DE NIVELL SUPERIOR
        // Contenidor 'JFrame' i propietats
        JFrame miJFrame = new JFrame("Finestra de prova");
        miJFrame.setSize(300, 200);
        miJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // 2- COMPONENT DE NIVELL INTERMIG
        // Component 'JPanel' i propietats
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 200);
        
        // 3- COMPONENTS BÀSICS
        JTextField texte1 = new JTextField("0",20);
        JTextField texte2 = new JTextField("0",20);
        
        JButton miJButtonSuma = new JButton("Acceptar");
        miJButtonSuma.setBounds(10, 100, 120, 20);
        JButton miJButtonResta = new JButton("Cancel·lar");
        miJButtonResta.setBounds(140, 100, 120, 20);
        
        // 4- CONNEXIÓ DELS COMPONENTS BÀSICS AL NIVELL INTERMIG
        miJPanel.add(texte1);
        miJPanel.add(texte2);
        miJPanel.add(miJButtonSuma);
        miJPanel.add(miJButtonResta);
               
        // 5- CONNEXIÓ DEL NIVELL INTERMIG AL NIVELL SUPERIOR
        miJFrame.add(miJPanel);
        
        // 6- ACTIVAR EL JFrame
        miJFrame.setVisible(true);
    }
   
}
