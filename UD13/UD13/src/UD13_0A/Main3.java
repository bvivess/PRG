package UD13_0A;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

public class Main3 {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Reserveringen");
        myFrame.setSize(800, 500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myJPanel = new JPanel();
        myJPanel.setLayout(new BoxLayout(myJPanel, BoxLayout.X_AXIS));

        JPanel myJPanel1 = new JPanel();
        //willekeurigPanel.setSize(400, 500);
        myJPanel1.setBackground(Color.YELLOW);
        myJPanel1.setVisible(true);

        JPanel myJPanel2 = new JPanel();
        //overzichtPanel.setSize(400, 500);
        myJPanel2.setBackground(Color.red);
        myJPanel2.setVisible(true);


        myJPanel.add(myJPanel1);
        myJPanel.add(myJPanel2);

        myFrame.add(myJPanel);
        myFrame.setVisible(true);
    }
}