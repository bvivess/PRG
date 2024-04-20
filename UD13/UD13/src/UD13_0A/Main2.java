package UD13_0A;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main2 {
    public static void main(String[] args) {
        // FRAME
        JFrame miFrame = new JFrame("Prova");
        miFrame.setSize(1200, 500);
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // PANELL
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new BoxLayout(miJPanel, BoxLayout.X_AXIS));

        // PANELL1
        JPanel miJPanel1 = new JPanel();
        miJPanel1.setSize(400, 500);
        miJPanel1.setBackground(Color.BLUE);
        //miJPanell1.setVisible(true);
        
        JButton miJButtonAcceptar = new JButton("Acceptar");
        JButton miJButtonCancellar = new JButton("Cancel·lar");

        // PANELL2
        JPanel miJPanel2 = new JPanel();
        miJPanel2.setSize(400, 500);
        miJPanel2.setBackground(Color.RED);
        //miJPanel2.setVisible(true);

        // CONNEXIONS
        // Elements
        miJPanel1.add(miJButtonAcceptar);
        miJPanel1.add(miJButtonCancellar);
        // Panel
        miJPanel.add(miJPanel1);
        miJPanel.add(miJPanel2);
        // Frame
        miFrame.add(miJPanel);
        miFrame.setVisible(true);
    }
}