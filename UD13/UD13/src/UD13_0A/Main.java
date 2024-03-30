package UD13_0A;

import java.awt.GridBagLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {
    public static void main(String[] args){

        // 1- CONTENIDOR DE NIVELL SUPERIOR
        // Contenidor 'JFrame'
        JFrame miJFrame = new JFrame("Ejemplo - Frame Swing");
        miJFrame.setSize(500,300);

        
        // 2- COMPONENT DE NIVELL INTERMIG
        // Component 'JPanel'
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(200, 300);
        miJPanel.setLayout(new GridBagLayout());  // usamos este dise?o para centrar los componentes de JPanel`

        // 3- ELEMENTS ATÒMICS
        // Component 'JTextField'
        JLabel miJLabel = new JLabel();
        miJLabel.setText("Etiqueta de prova:  ");

        // Component 'JTextArea'
        JTextArea miJTextArea = new JTextArea(5,20);

        // 4- CONNEXIÓ DELS ELEMENTS ATÒMICS AL NIVELL INTERMIG
        miJPanel.add(miJLabel);
        miJPanel.add(miJTextArea);

        // 4- CONNEXIÓ DEL NIVELL INTERMIG AL NIVELL SUPERIOR
        miJFrame.add(miJPanel);
        miJFrame.setVisible(true);

    }

}

