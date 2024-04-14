package ACT11_6;

import java.util.ArrayList;

// 'ArrayList' amb un número màxim d'elements prefixat
public class ArrayMax<T> extends ArrayList<T> { 
    private final int maxSize;

    public ArrayMax(int maxSize) {
        this.maxSize = maxSize;
    }

    // Sobreescriptura de 'add'
    @Override
    public boolean add(T e) {
        if (this.size() >= this.maxSize)
            return false;
        else
            return super.add(e);
    }

}