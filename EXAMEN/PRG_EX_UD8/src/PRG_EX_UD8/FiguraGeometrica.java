package PRG_EX_UD8;

/** Posició en un pla de 2 dimensions
 *
 * @author winadmin
 */
public class FiguraGeometrica {
    protected String color;
    protected Posicio posicio;

    public FiguraGeometrica(String color, Posicio posicio) {
        this.color = color;
        this.posicio = posicio;
    }
    
    @Override
    public String toString() {
        return "Figura Geomètrica: Color: " + posicio.x + this.color + " " + posicio.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        boolean iguals=true;
        FiguraGeometrica f = (FiguraGeometrica) o; 
        if (f.color.equals(this.color))
            System.out.println("Color igual");
        else {
            System.out.println("Color diferent");
            iguals = false;
        }
        if (f.posicio.equals(this.posicio))
            System.out.println("Posició igual");
        else {
            System.out.println("Color o posició diferent");
            iguals = false;
        }
        return iguals;
    }
    
}
