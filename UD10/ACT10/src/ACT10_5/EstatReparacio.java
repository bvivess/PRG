package ACT10_5;

import java.util.*;

// ENUM amb els possibles estats d'un vehicle
enum EstatReparacio {
    PENDENT       ("'Pendent de reparació'"),
    EN_DIAGNOSTIC ("'En Diagnòstic'"),
    EN_REPARACIO  ("'En Reparació'"),
    REPARAT       ("'Reparat'");
    
    private final String descripcio; // atribut
    
    EstatReparacio(String descripcio) { // constructor
        this.descripcio = descripcio;
    }
    
    public String getDescripcio() { // getter
        return this.descripcio;
    }

    
}


