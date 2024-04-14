package ACT11_6;

import java.util.ArrayList;

/** ArraySet: 'ArrayList amb comportament de 'Set'
 * public class ArraySet<E> extends ArrayList<E> 
 * 
 * Tipus de par�metre:
 *    1. E - the type of elements in this ArrayList
 */
public class ArraySet<E> extends ArrayList<E> {  // 'E' representa el tipus o classe dels objectes relacionats

    // Sobreescriptura d''add'
    @Override
    public boolean add(E e) {
        if (!this.contains(e)) // 'contains()' t� en compte el m�tode 'equals' de la classe relacionada
            return super.add(e);
        else
            return false;
    }

}