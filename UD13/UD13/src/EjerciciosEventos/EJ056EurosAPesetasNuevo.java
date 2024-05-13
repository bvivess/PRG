/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosEventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author atorre
 */
public class EJ056EurosAPesetasNuevo extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel etiqueta;
    private JTextField texto;
    private JLabel etiqueta2;
    private JButton boton;
    private JLabel etiqueta3;
    private JButton boton2;
    private JButton boton3;

    public EJ056EurosAPesetasNuevo() {
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
        boton2 = new JButton("Limpiar");
        boton3 = new JButton("Salir");
        
        boton.addActionListener(this);
        boton2.addMouseListener(new MyClickListener1());
        boton3.addMouseListener(new MyClickListener2());

        panel.add(etiqueta);
        panel.add(texto);
        panel.add(etiqueta2);
        panel.add(boton);
        panel.add(etiqueta3);
        panel.add(boton2);
        panel.add(boton3);
        
        setContentPane(panel);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int euros = Integer.parseInt(texto.getText());
            
        etiqueta3.setText(String.valueOf(euros*166.386));
        pack();
    }

    private class MyClickListener1 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            texto.setText("");
        }
    }
    
    private class MyClickListener2 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            System.exit(0);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EJ056EurosAPesetasNuevo ej56 = new EJ056EurosAPesetasNuevo();
    }
}
