package PROVA;

/**
 *
 * @author winadmin
 */
public class Persona {
    private String nombre;
    private int edad;

    // Constructor, getters, setters, etc.

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return edad == persona.edad && nombre.equals(persona.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + edad;
        return result;
    }
}