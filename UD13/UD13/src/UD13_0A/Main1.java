package UD13_0A;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.w3c.dom.html.HTMLIFrameElement;

public class Main1 {
    public static void main(String[] args){

        // 1- CONTENIDOR DE NIVELL SUPERIOR
        // Contenidor 'JFrame'
        JFrame miJFrame = new JFrame("Jerarquia de composición");
        miJFrame.setSize(300, 200);
        miJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 2- COMPONENT DE NIVELL INTERMIG
        // Component 'JPanel' i propietats
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 200);
        miJPanel.setLayout(null);  // BorderLayout(),GridBagLayout(), BoxLayout(miJPanel,BoxLayout.X_AXIS), FlowLayout() ...

        // 3- ELEMENTS ATÒMICS
        // Component 'JTextField' i propietats
        JLabel miJLabel = new JLabel("Mensaje");
        miJLabel.setBounds(1, 1, 120, 20);
        // Components 'JButton' i propietats
        JButton miJButtonbotoAcceptar = new JButton("Aceptar");
        miJButtonbotoAcceptar.setBounds(1, 21, 120, 20);
        JButton miJButtonCancellar = new JButton("Cancelar");
        miJButtonCancellar.setBounds(1, 51, 120, 20);

        // 4- CONNEXIÓ DELS ELEMENTS ATÒMICS AL NIVELL INTERMIG
        miJPanel.add(miJLabel);
        miJPanel.add(miJButtonbotoAcceptar);
        miJPanel.add(miJButtonCancellar);


        // 5- CONNEXIÓ DEL NIVELL INTERMIG AL NIVELL SUPERIOR
        miJFrame.add(miJPanel);
        
        // 6- ACTIVAR EL JFrame
        miJFrame.setVisible(true);


    }

}

