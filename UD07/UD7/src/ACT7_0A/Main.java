package ACT7_0A;

/**
 *
 * @author T:Vives
 * 
 * Exemple de Herència Simple
 *     Persona
 *        ^ 
 *        |
 *    Estudiant
 * 
 */
public class Main {
    public static void main(String[] args) {
        // Crea un objective 'estudiant'
        Estudiant estudiant = new Estudiant("Joan", 20, "Programació");

        // Mostrar les dades d''estudiant'
        estudiant.mostraPersona();  // mètode de la superclasse
        estudiant.mostraEstudiant();  // mètode de la subclasse
    }
}
