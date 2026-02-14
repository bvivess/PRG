package ACT8_5;

import java.util.Objects;

public abstract class Tarjeta {
    protected String codiTarjeta;
    protected double comisUs;
    protected double importMaximCaixer;
    protected double importMaximCompra;

    public Tarjeta(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra) {
        this.codiTarjeta = codiTarjeta;
        this.comisUs = comisUs;
        this.importMaximCaixer = importMaximCaixer;
        this.importMaximCompra = importMaximCompra;
    }
    
    public Tarjeta(String codiTarjeta) {
        this.codiTarjeta = codiTarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codiTarjeta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarjeta other = (Tarjeta) obj;
        return Objects.equals(this.codiTarjeta, other.codiTarjeta);
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "codiTarjeta=" + codiTarjeta + ", comisUs=" + comisUs + ", importMaximCaixer=" + importMaximCaixer + ", importMaximCompra=" + importMaximCompra + '}';
    }
    
}
