package UD13_0A;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;


public class Main3 {
    public static void main(String[] args) {
        // FRAME
        JFrame myFrame = new JFrame("Prova");
        myFrame.setSize(1200, 500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // PANEL
        JPanel myJPanel = new JPanel();
        myJPanel.setLayout(new BoxLayout(myJPanel, BoxLayout.X_AXIS));

        // PANEL1
        JPanel myJPanel1 = new JPanel();
        myJPanel1.setSize(400, 500);
        myJPanel1.setBackground(Color.YELLOW);
        myJPanel1.setVisible(true);
        
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");

        // PANEL2
        JPanel myJPanel2 = new JPanel();
        myJPanel2.setSize(400, 500);
        myJPanel2.setBackground(Color.red);
        myJPanel2.setVisible(true);

        // CONNEXIONS
        // Elements
        myJPanel1.add(botonAceptar);
        myJPanel1.add(botonCancelar);
        // Panel
        myJPanel.add(myJPanel1);
        myJPanel.add(myJPanel2);
        // Frame
        myFrame.add(myJPanel);
        myFrame.setVisible(true);
    }
}