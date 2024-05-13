package UD13_0Z;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


// Vista (View)
class CalculadoraView {
    private JFrame frame;
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;
    private JButton sumarButton;

    public CalculadoraView() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JPanel panel = new JPanel(new GridLayout(4, 2));

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultLabel = new JLabel("Resultat:");

        sumarButton = new JButton("Sumar");

        panel.add(new JLabel("Número 1:"));
        panel.add(num1Field);
        panel.add(new JLabel("Número 2:"));
        panel.add(num2Field);
        panel.add(sumarButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    public int getNum1() {
        return Integer.parseInt(num1Field.getText());
    }

    public int getNum2() {
        return Integer.parseInt(num2Field.getText());
    }

    public void setResultado(int resultat) {
        resultLabel.setText("Resultat: " + resultat);
    }

    public void addSumarListener(ActionListener listener) {
        sumarButton.addActionListener(listener);
    }
}
