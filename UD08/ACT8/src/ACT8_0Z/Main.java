package ACT8_0Z;

/** Classe principal per demostrar el polimorfisme
 * 
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crea inst�ncies de diferents tipus de documents
        Document documentTexte = new DocumentTexte("Texte inicial");
        Document documentFullCalcul = new DocumentFullCalcul("Texte inicial");

        // Realitza operacions en cada document
        realizaOperacions(documentTexte);
        System.out.println(documentTexte.toString());
        System.out.println("------------------------");
        realizaOperacions(documentFullCalcul);
        System.out.println(documentFullCalcul.toString());
    }

    // Realitza operacions en el document gen�ric
    private static void realizaOperacions(Document document) {
        document.obreDocument();
        if (document instanceof DocumentTexte)
            document.afegeixDocument(" texte");
        else if (document instanceof DocumentFullCalcul)
            document.afegeixDocument(" full C�lcul");
        document.guardaDocument();
        document.tancaDocument();
    }
}
