package EX_UD11_5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EstatCivil[] estatsCivils = EstatCivil.values();  // Transformació
       
        for (EstatCivil e : estatsCivils) {
            System.out.println( e.getDescripcioCA() + " " +
                                e.getDescripcioES() + " " +
                                e.getDescripcioEN() + " " );
        }
    }

    
}
