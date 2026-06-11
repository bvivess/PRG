package ACT10_7E;

import java.util.ArrayList;

/** CircularArray: 'ArrayList' amb un número màxim d'elements prefixat
 public class ArraySet<E>(int maxSize) extends ArrayList<E> 
 * 
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements en aquest 'ArrayMax'
 *    2. maxSize - nombre màxim d'elements permesos
 */
public class CircularArray<E> extends ArrayList<E> {

    // Sobreescriptura de get
    @Override
    public E get(int i) {
        return super.get(i%this.size());
    }
}