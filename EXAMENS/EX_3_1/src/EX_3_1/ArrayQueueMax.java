package EX_3_1;

import java.util.ArrayList;

public class ArrayQueueMax<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayQueueMax'
    private final int maxSize;  // nombre màxim d'elements de l''ArrayQueueMax'

    public ArrayQueueMax(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public boolean offer(E e) {
        if (this.size() >= this.maxSize)
            return false;
        else
            return super.add(e);  // els elements s?afegeixen al final de la cua 
    }
    
    public E poll() {
        return this.remove(0);  // els elements es treuen pel principi de la cua
    }
    
}