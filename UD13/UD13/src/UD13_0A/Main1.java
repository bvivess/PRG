package UD13_0A;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main1 {
    public static void main(String[] args){

        // 1- CONTENIDOR DE NIVELL SUPERIOR
        // Contenidor 'JFrame' i propietats
        JFrame miJFrame = new JFrame("Finestra de prova");
        miJFrame.setSize(300, 200);
        miJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 2- COMPONENT DE NIVELL INTERMIG
        // Component 'JPanel' i propietats
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 200);
        miJPanel.setLayout(null);  // BorderLayout(),GridBagLayout(), BoxLayout(miJPanel,BoxLayout.X_AXIS), FlowLayout() ...

        // 3- COMPONENTS BÀSICS
        // Component 'JTextField' i propietats
        JLabel miJLabel = new JLabel("Missatge de prova");
        miJLabel.setBounds(1, 10, 120, 20);
        // Components 'JButton' i propietats
        JButton miJButtonAcceptar = new JButton("Acceptar");
        miJButtonAcceptar.setBounds(10, 100, 120, 20);
        JButton miJButtonCancellar = new JButton("Cancel·lar");
        miJButtonCancellar.setBounds(140, 100, 120, 20);

        // 4- CONNEXIÓ DELS COMPONENTS BÀSICS AL NIVELL INTERMIG
        miJPanel.add(miJLabel);
        miJPanel.add(miJButtonAcceptar);
        miJPanel.add(miJButtonCancellar);

        // 5- CONNEXIÓ DEL NIVELL INTERMIG AL NIVELL SUPERIOR
        miJFrame.add(miJPanel);
        
        // 6- ACTIVAR EL JFrame
        miJFrame.setVisible(true);

    }

}

