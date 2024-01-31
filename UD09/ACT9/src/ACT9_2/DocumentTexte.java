package ACT9_2;

/**
 *
 * @author winadmin
 */
// Clase para representar un documento de texto
class DocumentTexte implements Document {
    private String contingut;

    public DocumentTexte(String contingut) {
        this.contingut = contingut;
    }

    @Override
    public void obreDocument() {
        System.out.println("Obrir document de texte");
    }

    @Override
    public void tancaDocument() {
        System.out.println("Tancar document de texte");
    }

    @Override
    public void guardaDocument() {
        System.out.println("Guardando documento de texto");
    }
}