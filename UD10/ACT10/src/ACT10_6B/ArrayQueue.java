package ACT10_6B;

import java.util.ArrayList;

/** ArrayQueue: 'ArrayList' amb comportament de 'Queue' (FIFO)
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements en aquest 'ArrayQueue'
 */
public class ArrayQueue<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayQueue'

    public boolean offer(E e) {
        this.add(0, e);
        return true;
    }
    
    public E poll() {
        return this.remove(this.size()-1);
    }
    
}