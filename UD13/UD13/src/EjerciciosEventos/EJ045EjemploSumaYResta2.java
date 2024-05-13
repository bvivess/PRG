/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EjerciciosEventos;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author atorre
 */
public class EJ045EjemploSumaYResta2 extends JFrame {
    private JTextField num1;
    private JTextField num2;
    private JButton sumar;
    private JButton restar;
    private JLabel resultado;
    private String labelPrefix;
    
    public EJ045EjemploSumaYResta2() {
        initComponents();
    }
    private void initComponents() {
        setSize(300,150);
        setTitle("Suma y Resta");

        num1 = new JTextField("0", 10);
        num2 = new JTextField("0", 10);
        sumar = new JButton("Sumar");
        restar = new JButton("Restar");
        labelPrefix = "El resultado de la operación es: ";
        resultado = new JLabel(labelPrefix);

        sumar.addMouseListener(new SumaYRestaClick());
        restar.addMouseListener(new SumaYRestaClick());
        JPanel panel = new JPanel();

        panel.add(num1);
        panel.add(num2);
        panel.add(sumar);
        panel.add(restar);
        panel.add(resultado);

        add(panel);
    }

    private class SumaClick extends MouseAdapter {
        public void mouseClicked(MouseEvent ev) {
            int n1 = Integer.valueOf(num1.getText());
            int n2 = Integer.valueOf(num2.getText());
            int res = n1 + n2;
            resultado.setText(labelPrefix + res);
        }
    }

    private class RestaClick extends MouseAdapter {
        public void mouseClicked(MouseEvent ev) {
            int n1 = Integer.valueOf(num1.getText());
            int n2 = Integer.valueOf(num2.getText());
            int res = n1 - n2;
            resultado.setText(labelPrefix + res);
        }
    }

    private class SumaYRestaClick extends MouseAdapter {
        public void mouseClicked(MouseEvent ev) {
            int n1 = Integer.valueOf(num1.getText());
            int n2 = Integer.valueOf(num2.getText());
            int res = 0;
            
            if (ev.getSource() == sumar)
                res = n1 + n2;
            else if (ev.getSource() == restar)
                res = n1 - n2;
            resultado.setText(labelPrefix + res);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EJ045EjemploSumaYResta2 ej45 = new EJ045EjemploSumaYResta2();
        ej45.setVisible(true);
    }


}
