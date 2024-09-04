package ACT10_6A;

import java.util.ArrayList;

/** ArraySet: 'ArrayList' amb comportament de 'Set'
 * public class ArraySet<E> extends ArrayList<E> 
 * 
 * Tipus de par�metre:
 *    1. E - el tipus d'elements en aquest 'ArraySet'
 */
public class ArraySet<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArraySet'

    // Sobreescriptura d''add'
    @Override
    public boolean add(E e) {
        if (!this.contains(e)) // 'contains()' t� en compte el m�tode 'equals' de la classe relacionada
            return super.add(e);
        else
            return false;
    }

}