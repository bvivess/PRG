/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosEventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author atorre
 */
public class EJ046EurosAPesetas extends JFrame {

    private JPanel panel;
    private JLabel etiqueta;
    private JTextField texto;
    private JLabel etiqueta2;
    private JButton boton;
    private JLabel etiqueta3;

    public EJ046EurosAPesetas() {
        initComponents();
    }

    private void initComponents() {
        setSize(300, 400);
        setTitle("Conversor de euros a pesetas");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        
        etiqueta = new JLabel("Importe en euros: ");
        texto = new JTextField(20);
        etiqueta2 = new JLabel("Pulse el botón para convertir el importe en pesetas: ");
        boton = new JButton("Convertir");
        etiqueta3 = new JLabel("");
        
        boton.addMouseListener(new MyClickListener());
        
        panel.add(etiqueta);
        panel.add(texto);
        panel.add(etiqueta2);
        panel.add(boton);
        panel.add(etiqueta3);
        
        setContentPane(panel);
        
        pack();
        setVisible(true);
    }

    private class MyClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            int euros = Integer.parseInt(texto.getText());
            
            etiqueta3.setText(String.valueOf(euros*166.386));
            pack();
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EJ046EurosAPesetas ej46 = new EJ046EurosAPesetas();
    }
}
