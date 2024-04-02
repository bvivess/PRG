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
        // Component 'JPanel'
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 200);
        miJPanel.setLayout(null);  // BorderLayout(),GridBagLayout(), BoxLayout(miJPanel,BoxLayout.X_AXIS), FlowLayout() ...

        // 3- ELEMENTS ATÒMICS
        // Component 'JTextField'
        JLabel etiqueta1 = new JLabel("Mensaje");
        etiqueta1.setBounds(1, 1, 120, 20);

        // Component 'JTextArea'
        JButton botoAcceptar = new JButton("Aceptar");
        botoAcceptar.setBounds(1, 21, 120, 20);
        JButton botoCancellar = new JButton("Cancelar");
        botoCancellar.setBounds(1, 51, 120, 20);

        // 4- CONNEXIÓ DELS ELEMENTS ATÒMICS AL NIVELL INTERMIG
        miJPanel.add(etiqueta1);
        miJPanel.add(botoAcceptar);
        miJPanel.add(botoCancellar);


        // 4- CONNEXIÓ DEL NIVELL INTERMIG AL NIVELL SUPERIOR
        miJFrame.add(miJPanel);
        miJFrame.setVisible(true);


    }

}

