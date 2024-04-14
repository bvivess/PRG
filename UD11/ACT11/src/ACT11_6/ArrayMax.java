package ACT11_6;

import java.util.ArrayList;

// 'ArrayList' amb un n�mero m�xim d'elements prefixat
public class ArrayMax<E> extends ArrayList<E> {  // 'E' representa el tipus o classe dels objectes relacionats
    private final int maxSize;  // nombre m�xim d'elements de l''ArrayMax'

    public ArrayMax(int maxSize) {
        this.maxSize = maxSize;
    }

    // Sobreescriptura d''add'
    @Override
    public boolean add(E e) {
        if (this.size() >= this.maxSize)
            return false;
        else
            return super.add(e);
    }

}