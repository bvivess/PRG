/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EjercicioJSplitPane.java
 *
 * Created on 21-abr-2010, 21:26:59
 */

package EjerciciosSwing;

import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

/**
 *
 * @author atorre
 */
public class EJ155EjercicioJSplitPane extends javax.swing.JFrame {

    /** Creates new form EjercicioJSplitPane */
    public EJ155EjercicioJSplitPane() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setDividerLocation(50);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bird.gif"))); // NOI18N
        jSplitPane1.setRightComponent(jLabel1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        String selected = (String) jList1.getSelectedValue();

        if (selected.equals("Bird")) {
            String file = "src/images/bird.gif";
            jLabel1.setIcon(new ImageIcon(file));
        }
        else if (selected.equals("Cat")) {
            String file = "src/images/cat.gif";
            jLabel1.setIcon(new ImageIcon(file));
        }
        else if (selected.equals("Dog")) {
            String file = "src/images/dog.gif";
            jLabel1.setIcon(new ImageIcon(file));
        }
        else if (selected.equals("Rabbit")) {
            String file = "src/images/rabbit.gif";
            jLabel1.setIcon(new ImageIcon(file));
        }
        else if (selected.equals("Pig")) {
            String file = "src/images/pig.gif";
            jLabel1.setIcon(new ImageIcon(file));
        }
    }//GEN-LAST:event_jList1ValueChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EJ155EjercicioJSplitPane().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

}
