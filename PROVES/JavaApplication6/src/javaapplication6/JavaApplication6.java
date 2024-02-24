package javaapplication6;

public class JavaApplication6 {
    public static void main(String[] args) {
        Telefono myTelefono = new Telefono("Xiaomi",1000);
        myTelefono.setCapacidad(10000);
        
        System.out.println(myTelefono.getMarca());
        System.out.println(myTelefono.duracionBateria() + "h");
        
        Tablet myTablet = new Tablet("LG", 2500);
        System.out.println(myTablet.getMarca());
        System.out.println(myTablet.duracionBateria() + "h");
    }
}
