package ACT10_6C;

import java.util.ArrayList;

/** ArrayDeque: 'ArrayList' amb comportament de 'Deque' (LIFO)
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements en aquest 'ArrayDeque'
 */
public class ArrayDeque<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayDeque'

    // Sobreescriptura d''add'
    /*
    @Override
    public boolean add(E e) {
        this.add(0, e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        super.add(0, element);
    } */

    public boolean push(E e) {
        this.add(0, e);
        return true;
    }

    public E pop() {
        return this.remove(0);
    }
    
}