/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosLayouts;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author atorre
 */
public class EJ075GridLayout extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JButton boton1;
    private JButton boton3;
    private JButton boton2;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JLabel label1;
    private JLabel label2;
    private JTextField texto2;
    private JTextField texto1;
    private GridLayout layout1;
    private GridLayout layout2;
    private JLabel label3;
    private JSeparator separador;

    public EJ075GridLayout() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Grid Layout");
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        separador = new JSeparator();
        
        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        boton3 = new JButton("Boton 3");
        boton4 = new JButton("Boton 4");
        boton5 = new JButton("Boton 5");
        boton6 = new JButton("Aplicar GAP");
        
        label1 = new JLabel("GAP Horizontal");
        label2 = new JLabel("GAP Vertical");
        label3 = new JLabel("");
        
        texto1 = new JTextField("");
        texto2 = new JTextField("");
        
        layout1 = new GridLayout(0,2,0,0);
        layout2 = new GridLayout(0,3,0,0);

        panel1.setLayout(layout1);
        panel2.setLayout(layout2);

        panel1.add(boton1);
        panel1.add(boton2);
        panel1.add(boton3);
        panel1.add(boton4);
        panel1.add(boton5);

        panel2.add(label1);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(texto1);
        panel2.add(texto2);
        panel2.add(boton6);
        
        boton6.addMouseListener(new MyMouseClick());

        add(panel1, BorderLayout.PAGE_START);
        add(separador, BorderLayout.CENTER);
        add(panel2, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }
    
    private class MyMouseClick extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            layout1.setHgap(Integer.parseInt(texto1.getText()));
            layout1.setVgap(Integer.parseInt(texto2.getText()));
            
            layout1.layoutContainer(panel1);
            pack();
        }
    }

    public static void main(String[] args) {
        EJ075GridLayout ej75 = new EJ075GridLayout();
    }
}
