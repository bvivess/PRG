/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosLayouts;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author atorre
 */
public class EJ063BorderLayout extends JFrame {

    EJ063BorderLayout () {
        initComponents();
    }
    
    private void initComponents() {
        layout = new BorderLayout(0, 0);
        setLayout(layout);
        
        String[] names = {"NORTE", "SUR", "ESTE", "OESTE", "CENTRO"};
        String[] positions = {BorderLayout.PAGE_START, BorderLayout.PAGE_END, BorderLayout.LINE_START, BorderLayout.LINE_END, BorderLayout.CENTER};
        
        buttons = new JButton[5];

        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].addMouseListener(new MyMouseListener());
            getContentPane().add(buttons[i], positions[i]);
        }
        
        pack();
        setVisible(true);
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            for (int i = 0; i < 5; i++) {
                if (event.getSource() == buttons[i]) {
                    buttons[i].setVisible(false);
                }
                else {
                    buttons[i].setVisible(true);
                }
            }
        }
    }

    public static void main(String[] args) {
        EJ063BorderLayout gui = new EJ063BorderLayout();
    }

    private BorderLayout layout;
    private JButton[] buttons;
}
