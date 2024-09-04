package ACT10_6B;

import java.util.ArrayList;

/** ArrayMax: 'ArrayList' amb un n�mero m�xim d'elements prefixat
 * public class ArraySet<E>(int maxSize) extends ArrayList<E> 
 * 
 * Tipus de par�metre:
 *    1. E - el tipus d'elements en aquest 'ArrayMax'
 *    2. maxSize - nombre m�xim d'elements permesos
 */
public class ArrayMax<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayMax'
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