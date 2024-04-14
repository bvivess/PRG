package ACT11_6;

import java.util.ArrayList;

// 'ArrayList' amb comportament de 'Set'
public class ArraySet<E> extends ArrayList<E> {  // 'E' representa el tipus o classe dels objectes relacionats

    // Sobreescriptura d''add'
    @Override
    public boolean add(E e) {
        if (!this.contains(e)) // 'contains()' té en compte el mètode 'equals' de la classe relacionada
            return super.add(e);
        else
            return false;
    }

}