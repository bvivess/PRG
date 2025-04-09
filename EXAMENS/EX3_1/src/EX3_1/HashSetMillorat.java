package EX3_1;

import java.util.HashSet;

public class HashSetMillorat<E> extends HashSet<E> { // 'E' representa la classe dels elements del 'HashSetMillorat'

    public Object cerca(E element) {
        for (E item : this) {
            if (item.equals(element)) {
                return item;
            }
        }
        return element;
    }
}

