package ACT12_0D;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        String nomArxiu = "c:\\temp\\arxiu.txt";
        
        Persona p1 = new Persona("Maria", 30);
        Persona p2 = new Persona("Joana", 35);
        Persona p3 = new Persona("Maria", 30);
        Set<Persona> empleats = new HashSet<Persona>();
        empleats.add(p1); empleats.add(p2); empleats.add(p3);
        Empleats e = new Empleats(empleats);

        // Serialització
        try (FileOutputStream fos = new FileOutputStream(nomArxiu);
             ObjectOutputStream out = new ObjectOutputStream(fos)
            ) {
            out.writeObject(e);
        } catch (IOException i) {
            System.out.println("Exception writing 'Empleats': " + i);
        }

        // Deserialització
        try (FileInputStream fis = new FileInputStream(nomArxiu);
             ObjectInputStream in = new ObjectInputStream(fis)
            ) {
            Empleats newE = (Empleats) in.readObject();
            for (Persona p : newE.persones)
                System.out.println(p);

        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading 'Empleats': " + i);
        }
    }
}