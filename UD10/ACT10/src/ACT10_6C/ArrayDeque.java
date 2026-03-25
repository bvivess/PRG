package ACT10_6C;

import java.util.ArrayList;

/** ArrayDeque: 'ArrayList' amb comportament de 'Deque' (LIFO)
 *     Inserció ? els elements s?afegeixen al principi de la cua
 *     Extracció ? els elements es treuen pel principi de la cua
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements d'aquest 'ArrayDeque'
 */
public class ArrayDeque<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayDeque'

    // Sobreescriptura d''add'
    /*
    @Override
    public boolean add(E e) {
        return this.add(0, e);
    }

    @Override
    public void add(int index, E element) {
        super.add(0, element);
    } */

    public boolean push(E e) {
        super.add(0, e);  // els elements s?afegeixen al principi de la cua
        return true;
    }

    public E pop() {
        return this.remove(0);  // els elements es treuen pel principi de la cua
    }
    
}