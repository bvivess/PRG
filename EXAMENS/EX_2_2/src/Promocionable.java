public interface Promocionable {
    double SUPLEMENT_PREMIUM = 0.10;  // 10% de suplement
    double DESCOMPTE_BASE = 0.10; // 10% de descompte
    
    // Retorna el preu final amb el descompte aplicat si hi té dret
    abstract boolean esSostenible();
    abstract boolean esPremium();
}