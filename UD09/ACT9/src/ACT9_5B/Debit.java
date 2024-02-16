package ACT9_5B;

/**
 *
 * @author winadmin
 */
public class Debit extends Tarjeta {
    private double importCompraMinim;

    public Debit(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra, double importCompraMinim) {
        super(codiTarjeta, comisUs, importMaximCaixer, importMaximCompra);
        setImportCompraMinim(importCompraMinim);
    }

    public void setImportCompraMinim(double importCompraMinim) {
        this.importCompraMinim = importCompraMinim;
    }
    
}
