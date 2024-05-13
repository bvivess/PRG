/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosEventos;

import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author atorre
 */
public class EJ053VentanaSalirAux extends JFrame {
    private JPanel panel;
    private JButton boton1;
    private JButton boton2;

    public EJ053VentanaSalirAux() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("¿Seguro que desea salir?");
        
        panel = new JPanel();
        
        boton1 = new JButton("Aceptar");
        boton2 = new JButton("Cancelar");
        
        boton1.addMouseListener(new MyClickListener1());
        boton2.addMouseListener(new MyClickListener2());

        panel.add(boton1);
        panel.add(boton2);
        
        setContentPane(panel);
        
        pack();
        setVisible(true);
    }
    
    private class MyClickListener1 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            System.exit(0);
        }
    }

    private class MyClickListener2 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            dispose();
        }
    }

}
