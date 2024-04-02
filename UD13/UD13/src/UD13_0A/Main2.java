package UD13_0A;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main2 {
    public static void main(String[] args) {
        // FRAME
        JFrame myFrame = new JFrame("Prova");
        myFrame.setSize(1200, 500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // PANELL
        JPanel myJPanel = new JPanel();
        myJPanel.setLayout(new BoxLayout(myJPanel, BoxLayout.X_AXIS));

        // PANELL1
        JPanel miJPanell1 = new JPanel();
        miJPanell1.setSize(400, 500);
        miJPanell1.setBackground(Color.BLUE);
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
        miJPanell1.add(miJButtonAcceptar);
        miJPanell1.add(miJButtonCancellar);
        // Panel
        myJPanel.add(miJPanell1);
        myJPanel.add(miJPanel2);
        // Frame
        myFrame.add(myJPanel);
        myFrame.setVisible(true);
    }
}