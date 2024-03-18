package EX_UD09_IIIB_BAK;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Factura implements DocumentComptabilitzable {
    private int idFactura;
    private String dataFactura;
    private double totalFactura;
    private AsientoComptable asientoComptables;
    
    public Factura(int idFactura, String dataFactura, double totalFactura, AsientoComptable asientoComptables) {
        this.idFactura = idFactura;
        this.dataFactura = dataFactura;
        this.totalFactura = totalFactura;
        this.asientoComptables = asientoComptables;
    }
    
    public boolean cercaClient() {
        return true;
    }

    public boolean cercaProveidor() {
        return true;
    }

    
    @Override
    public void realitzaContabilitzacio() {
        
    }
    
    
}
