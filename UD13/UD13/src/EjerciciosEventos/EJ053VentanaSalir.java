/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosEventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author atorre
 */
public class EJ053VentanaSalir extends JFrame {
    private JPanel panel;
    private JButton boton;

    public EJ053VentanaSalir() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Ventana con botón para salir");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        panel = new JPanel();
        boton = new JButton("Salir");
        boton.addMouseListener(new MyClickListener());
        
        addWindowListener(new MyWindowListener());
        
        panel.add(boton);
        
        setContentPane(panel);
        
        pack();
        setVisible(true);
    }
    
    private class MyClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            cerrarVentana();
        }
    }
    
    private class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent event) {
            cerrarVentana();
        }
    }

    private void cerrarVentana() {
        EJ053VentanaSalirAux aux = new EJ053VentanaSalirAux();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EJ053VentanaSalir ej53 = new EJ053VentanaSalir();
    }
}
