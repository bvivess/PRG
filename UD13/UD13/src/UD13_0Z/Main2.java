package UD13_0Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2 extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;
    private JButton sumarButton;

    public Main2() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultLabel = new JLabel("Resultat:");

        sumarButton = new JButton("Sumar");
        sumarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumar();
            }
        });

        add(new JLabel("Número 1:"));
        add(num1Field);
        add(new JLabel("Número 2:"));
        add(num2Field);
        add(sumarButton);
        add(resultLabel);
    }

    private void sumar() {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
            int resultat = num1 + num2;
            resultLabel.setText("Resultat: " + resultat);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introdueixi nombres vàlids.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }
}
