package ACT10_6B;

import java.util.ArrayList;

/** ArrayQueue: 'ArrayList' amb comportament de 'Queue' (FIFO):
 *     Inserció ? els elements s?afegeixen al final de la cua 
 *     Extracció ? els elements es treuen pel principi de la cua
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements d'aquest 'ArrayQueue'
 */
public class ArrayQueue<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayQueue'

    public boolean offer(E e) {
        return this.add(e);  // els elements s?afegeixen al final de la cua 
    }
    
    public E poll() {
        return this.remove(0);  // els elements es treuen pel principi de la cua
    }
    
}