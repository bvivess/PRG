/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosEventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author atorre
 */
public class EJ051EtiquetaBotonAreaTexto extends JFrame {
    private JPanel panel;
    private JLabel etiqueta;
    private JButton boton;
    private JTextArea area;

    public EJ051EtiquetaBotonAreaTexto() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Eventos con etiqueta, botón y área de texto");
        
        panel = new JPanel();
        
        etiqueta = new JLabel();
        etiqueta.setPreferredSize(new Dimension(200, 300));
        etiqueta.setMaximumSize(new Dimension(200, 300));
        etiqueta.setMinimumSize(new Dimension(200, 300));
        etiqueta.setBackground(Color.yellow);
        etiqueta.setOpaque(true);
        etiqueta.addMouseListener(new MyMouseListener());

        boton = new JButton("Pincha aquí");
        boton.addActionListener(new MyActionListener());

        area = new JTextArea(50, 20);      
        
        panel.add(etiqueta);
        panel.add(boton);
        panel.add(area);
        
        setContentPane(panel);
        
        pack();
        setVisible(true);
    }
    
    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent event) {
            area.append("El ratón entró en la etiqueta\n");
        }

        @Override
        public void mouseExited(MouseEvent event) {
            area.append("El ratón salió de la etiqueta\n");            
        }
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            area.append("Se hizo click en el botón\n");
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EJ051EtiquetaBotonAreaTexto ej51 = new EJ051EtiquetaBotonAreaTexto();
    }
}
