package ACT9_0Z;

/** Classe principal per demostrar el polimorfisme
 * 
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crea instàncies de diferents tipus de documents
        Document documentTexte = new DocumentTexte("Texte inicial");
        Document documentFullCalcul = new DocumentFullCalcul("Texte inicial");

        // Realizar operaciones en los documentos
        realizaOperacions(documentTexte);
        System.out.println(documentTexte.toString());
        System.out.println("------------------------");
        realizaOperacions(documentFullCalcul);
        System.out.println(documentFullCalcul.toString());
    }

    // Método que realiza operaciones en un documento genérico
    private static void realizaOperacions(Document document) {
        document.obreDocument();
        if (document instanceof DocumentTexte)
            document.afegeixDocument(" texte");
        else if (document instanceof DocumentFullCalcul)
            document.afegeixDocument(" full Càlcul");
        document.guardaDocument();
        document.tancaDocument();
    }
}
