package ACT7_0A;

/**
 *
 * @author T:Vives
 * 
 * Exemple de Her�ncia Simple
 *     Persona
 *        ^ 
 *        |
 *    Estudiant
 * 
 */
public class Main {
    public static void main(String[] args) {
        // Crea un objective 'estudiant'
        Estudiant estudiant = new Estudiant("Joan", 20, "Programaci�");

        // Mostrar les dades d''estudiant'
        estudiant.mostraPersona();  // m�tode de la superclasse
        estudiant.mostraEstudiant();  // m�tode de la subclasse
    }
}
