package ACT11_6;

import java.util.ArrayList;

// 'ArrayList' amb comportament de 'Set'
public class ArraySet<T> extends ArrayList<T> {  

    // Sobreescriptura de 'add'
    @Override
    public boolean add(T e) {
        if (!contains(e)) 
            return super.add(e);
        else
            return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        return super.equals(obj);

    }

}