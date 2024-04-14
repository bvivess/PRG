package ACT11_6;

import java.util.ArrayList;

/** ArrayMax: 'ArrayList' amb un número màxim d'elements prefixat
 * public class ArraySet<E>(int maxSize) extends ArrayList<E> 
 * 
 * Tipus de paràmetre:
 *    1. E - the type of elements in this ArrayMax
 *    2. maxSize - maximum number of elements allowed
 */
public class ArrayMax<E> extends ArrayList<E> {  // 'E' representa la classe dels elements relacionats
    private final int maxSize;  // nombre màxim d'elements de l''ArrayMax'

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