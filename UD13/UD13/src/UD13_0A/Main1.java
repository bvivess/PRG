package UD13_0A;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main1 {
    public static void main(String[] args){

        // 1- CONTENIDOR DE NIVELL SUPERIOR
        // Contenidor 'JFrame'
        JFrame miJFrame = new JFrame("Ejemplo - Frame Swing");
        miJFrame.setSize(500,300);

        
        // 2- COMPONENT DE NIVELL INTERMIG
        // Component 'JPanel'
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 300);
        miJPanel.setLayout(null );  // GridBagLayout(), BoxLayout(miJPanel,BoxLayout.X_AXIS), FlowLayout() ...

        // 3- ELEMENTS ATÒMICS
        // Component 'JTextField'
        JLabel miJLabel1 = new JLabel();
        JLabel miJLabel2 = new JLabel();
        miJLabel1.setText("Etiqueta de prova:  ");
        miJLabel1.setBounds(1, 1, 120, 20);
        miJLabel2.setText("Etiqueta de prova2:  ");
        miJLabel2.setBounds(1, 31, 120, 20);

        // Component 'JTextArea'
        JTextArea miJTextArea1 = new JTextArea(5,10);
        miJTextArea1.setBounds(121, 1, 100, 20);
        JTextArea miJTextArea2 = new JTextArea(5,10);
        miJTextArea2.setBounds(121, 31, 100, 20);

        // Component 'JButton
        JButton miJButton1 = new JButton("boton 1");
        miJButton1.setBounds(1, 200, 100, 100);

        // 4- CONNEXIÓ DELS ELEMENTS ATÒMICS AL NIVELL INTERMIG
        miJPanel.add(miJLabel1);
        miJPanel.add(miJLabel2);
        miJPanel.add(miJTextArea1);
        miJPanel.add(miJTextArea2);

        // 4- CONNEXIÓ DEL NIVELL INTERMIG AL NIVELL SUPERIOR
        miJFrame.add(miJPanel);
        miJFrame.setVisible(true);

    }

}

