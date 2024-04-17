package EX_UD11_5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EstatCivil[] estatsCivils = EstatCivil.values();  // Transformació 1
        List<EstatCivil> llistaDies = Arrays.asList(estatsCivils);  // Transformació 2
        Iterator<EstatCivil> iterator = llistaDies.iterator();
        while (iterator.hasNext()) {
            EstatCivil estatCivil = iterator.next();
            System.out.println( estatCivil + " " +
                                estatCivil.getDescripcioCA() + " " +
                                estatCivil.getDescripcioES() + " " +
                                estatCivil.getDescripcioEN() );
        }
    }

    
}
