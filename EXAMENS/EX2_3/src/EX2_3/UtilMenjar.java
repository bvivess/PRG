package EX2_3;

// Interfície UtilMenjar
public interface UtilMenjar {
    double IVA = 0.10;
    double PREU_PLAT = 10;
    
    abstract double calculaPreu();
    abstract boolean esPerVegetarians();
    abstract boolean esPerCeliacs();
}