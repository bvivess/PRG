package ACT11_6;

import java.util.ArrayList;

// 'ArrayList' amb comportament de 'Set'
public class ArraySet<T> extends ArrayList<T> {  // 'T' representa el tipus o classe dels objectes relacionats

    // Sobreescriptura d''add'
    @Override
    public boolean add(T e) {
        if (!this.contains(e)) // 'contains()' té en compte el mètode 'equals' de la classe relacionada
            return super.add(e);
        else
            return false;
    }

}