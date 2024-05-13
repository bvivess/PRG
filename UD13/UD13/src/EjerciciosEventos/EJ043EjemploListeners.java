package EjerciciosEventos;

import java.awt.event.*;
import javax.swing.*;

public class EJ043EjemploListeners extends JFrame {
    private JPanel panel;
    private JTextField text;
    private JButton button;
    
    public EJ043EjemploListeners () {
        initComponents();
    }
    
    private void initComponents() {
        setSize(300, 100);
        
        text = new JTextField("0", 20);
        text.setEditable(false);

        button = new JButton("Pulsa para incrementar");
        button.addMouseListener(new MyClickListener());

        panel = new JPanel();

        panel.add(text);
        panel.add(button);

        add(panel);
    }
    
    private class MyClickListener extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            numClicks++;
            text.setText(String.valueOf(numClicks));
        }
        private int numClicks;
    }

    public static void main(String[] args) {
        EJ043EjemploListeners ej43 = new EJ043EjemploListeners();
        ej43.setVisible(true);
    }

}
