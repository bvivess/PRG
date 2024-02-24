import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Email: " + email;
    }
}

class Agenda {
    private ArrayList<Contacto> contactos = new ArrayList<>();

    public void agregarContacto(String nombre, String telefono, String email) {
        Contacto nuevoContacto = new Contacto(nombre, telefono, email);
        contactos.add(nuevoContacto);
    }

    public void eliminarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(contacto);
                break;
            }
        }
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void guardarContactos(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(contactos);
            System.out.println("Contactos guardados en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarContactos(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            contactos = (ArrayList<Contacto>) ois.readObject();
            System.out.println("Contactos cargados desde " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class ProgramaRegistroDeContactos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String nombreArchivo = "contactos.dat";

        System.out.println("Programa de Registro de Contactos");

        agenda.cargarContactos(nombreArchivo);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Mostrar contactos");
            System.out.println("5. Guardar contactos");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.agregarContacto(nombre, telefono, email);
                    break;
                case 2:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                    break;
                case 3:
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoBuscado = agenda.buscarContacto(nombreBuscar);
                    if (contactoBuscado != null) {
                        System.out.println("Contacto encontrado: " + contactoBuscado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    agenda.mostrarContactos();
                    break;
                case 5:
                    agenda.guardarContactos(nombreArchivo);
                    break;
                case 6:
                    agenda.guardarContactos(nombreArchivo);
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
