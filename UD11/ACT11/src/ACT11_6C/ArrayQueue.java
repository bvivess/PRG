package ACT11_6C;

import java.util.ArrayList;

/** ArrayQueue: 'ArrayList' amb un número màxim d'elements prefixat
 public class ArraySet<E>(int maxSize) extends ArrayList<E> 
 * 
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements en aquest 'ArrayMax'
 *    2. maxSize - nombre màxim d'elements permesos
 */
public class ArrayQueue<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayQueue'

    // Sobreescriptura d''add'
    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    public boolean offer(E e) {
        return add(e);
    }
    
    public E poll() {
        E lastElement = this.remove(0); 
        return lastElement;
    }
    
}