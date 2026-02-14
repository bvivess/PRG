package ACT8_5A;

public class Credit extends Tarjeta {
    private double importEnNegatiu;

    public Credit(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra, double importEnNegatiu) {
        super(codiTarjeta, comisUs, importMaximCaixer, importMaximCompra);
        this.importEnNegatiu = importEnNegatiu;
    }
    
}
