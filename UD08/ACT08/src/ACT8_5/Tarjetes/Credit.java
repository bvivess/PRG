package ACT8_5.Tarjetes;

public final class Credit extends Tarjeta {
    private double importEnNegatiu;

    public Credit(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra, double importEnNegatiu) {
        super(codiTarjeta, comisUs, importMaximCaixer, importMaximCompra);
        this.importEnNegatiu = importEnNegatiu;
    }
    
}
