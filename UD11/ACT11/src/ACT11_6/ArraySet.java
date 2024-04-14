package ACT11_6;

import java.util.ArrayList;

// 'ArrayList' amb comportament de 'Set'
public class ArraySet<T> extends ArrayList<T> {  

    // Sobreescriptura de 'add'
    @Override
    public boolean add(T e) {
        if (!this.contains(e)) 
            return super.add(e);
        else
            return false;
    }

}