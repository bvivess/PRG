import javax.swing.JFrame;

public class MiVentana extends JFrame {
    public MiVentana() {
        // Configuración básica de la ventana
        setTitle("Ole Tu !!");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    public static void main(String[] args) {
        // Crear una instancia de MiVentana
        MiVentana miVentana = new MiVentana();
        
        // Hacer visible la ventana
        miVentana.setVisible(true);
    }
}
