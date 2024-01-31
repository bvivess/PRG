package ACT9_2;

/** Classe principal per demostrar el polimorfisme
 * 
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crea instàncies de diferents tipus de documents
        Document documentTexte = new DocumentTexte("Texte bla bla bla bla bla bla bla bla bla");
        Document documentFullCalcul = new DocumentFullCalcul("Fulla bla bla bla bla bla bla bla bla bla");

        // Realizar operaciones en los documentos
        realizaOperacions(documentTexte);
        System.out.println("------------------------");
        realizaOperacions(documentFullCalcul);
    }

    // Método que realiza operaciones en un documento genérico
    private static void realizaOperacions(Document document) {
        document.obreDocument();
        document.guardaDocument();
        document.tancaDocument();
    }
}
