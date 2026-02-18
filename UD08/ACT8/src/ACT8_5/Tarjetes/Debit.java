package ACT8_5.Tarjetes;

public final class Debit extends Tarjeta {
    private double importCompraMinim;

    public Debit(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra, double importCompraMinim) {
        super(codiTarjeta, comisUs, importMaximCaixer, importMaximCompra);
        this.importCompraMinim = importCompraMinim;
    }
    
}
