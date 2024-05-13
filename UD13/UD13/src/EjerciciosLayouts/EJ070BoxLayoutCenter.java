/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosLayouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author atorre
 */
public class EJ070BoxLayoutCenter extends JFrame {
    public EJ070BoxLayoutCenter() {
        initComponents();
    }
    
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout mainLayout = new BorderLayout(0,0);
        setLayout(mainLayout);
        
        JPanel panel1 = new JPanel();
        BoxLayout auxLayout = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(auxLayout);
        
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();

        label1.setMinimumSize(new Dimension(100, 50));
        label1.setPreferredSize(new Dimension(200, 75));
        label1.setMaximumSize(new Dimension(300, 100));
        label1.setOpaque(true);
        label1.setBackground(Color.yellow);

        label2.setMinimumSize(new Dimension(150, 50));
        label2.setPreferredSize(new Dimension(250, 75));
        label2.setMaximumSize(new Dimension(350, 100));
        label2.setOpaque(true);
        label2.setBackground(Color.red);

        label3.setMinimumSize(new Dimension(200, 50));
        label3.setPreferredSize(new Dimension(300, 75));
        label3.setMaximumSize(new Dimension(400, 100));
        label3.setOpaque(true);
        label3.setBackground(Color.green);

        label4.setMinimumSize(new Dimension(200, 75));
        label4.setPreferredSize(new Dimension(200, 75));
        label4.setMaximumSize(new Dimension(200, 75));
        label4.setOpaque(true);
        label4.setBackground(Color.blue);

        // Option 1: three labels on the same JPanel + BoxLayout (no glues)
//        label1.setAlignmentX(CENTER_ALIGNMENT);
//        label2.setAlignmentX(CENTER_ALIGNMENT);
//        label3.setAlignmentX(CENTER_ALIGNMENT);
//        label4.setAlignmentX(CENTER_ALIGNMENT);
//
//        panel1.add(label1);
//        panel1.add(label2);
//        panel1.add(label3);
//        panel1.add(label4);

        // Option 2: three labels on the different JPanel + BoxLayout + glues
        label1.setAlignmentX(CENTER_ALIGNMENT);
        label2.setAlignmentX(CENTER_ALIGNMENT);
        label3.setAlignmentX(CENTER_ALIGNMENT);
        label4.setAlignmentX(CENTER_ALIGNMENT);

        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));

        panel2.add(Box.createHorizontalGlue());
        panel2.add(label1);
        panel2.add(Box.createHorizontalGlue());
        panel3.add(Box.createHorizontalGlue());
        panel3.add(label2);
        panel3.add(Box.createHorizontalGlue());
        panel4.add(Box.createHorizontalGlue());
        panel4.add(label3);
        panel4.add(Box.createHorizontalGlue());
        panel5.add(Box.createHorizontalGlue());
        panel5.add(label4);
        panel5.add(Box.createHorizontalGlue());
        
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        panel1.add(panel5);
        panel1.add(Box.createVerticalGlue());

       
        add(panel1);

        pack();
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        EJ070BoxLayoutCenter gui = new EJ070BoxLayoutCenter();
    }
}
