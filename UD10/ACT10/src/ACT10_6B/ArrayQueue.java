package ACT10_6B;

import java.util.ArrayList;

/** ArrayQueue: 'ArrayList' amb comportament de 'Queue' (FIFO):
 *     Inserció ? els elements s?afegeixen al final de la cua 
 *     Extracció ? els elements es treuen pel principi de la cua
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements d'aquest 'ArrayQueue'
 */
public class ArrayQueue<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayQueue'
    
    // Sobreescriptura d''add'
    /*
    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        super.add(0, element);
    } */
    
    public boolean offer(E e) {
        return super.add(e);  // els elements s?afegeixen al final de la cua 
    }
    
    public E poll() {
        return this.remove(0);  // els elements es treuen pel principi de la cua
    }
    
}