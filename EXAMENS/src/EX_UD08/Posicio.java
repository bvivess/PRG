package EX_UD08;

/**
 *
 * @author winadmin
 */
public class Posicio {
    protected int x;
    protected int y;
    
    public Posicio(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Posició: (" + this.x + "," + this.y + ")";
    }
    
    @Override
    public boolean equals(Object o) {
        Posicio p = (Posicio) o;
        return ((p.x == this.x) && (p.y == this.y));
    }
}
