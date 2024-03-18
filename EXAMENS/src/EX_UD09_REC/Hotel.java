package EX_UD09_REC;

public class Hotel {
    Habitacio[] habitacions;

    public Hotel(Habitacio[] habitacions) {
        this.habitacions = habitacions;
    }

    @Override
    public String toString() {
        String text = "Hotel{" + "habitacions=";
        
        for (Habitacio h : this.habitacions)
            text += "\n\t" + h.toString();
        
        return text;
    }

    
}

