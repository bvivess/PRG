package EX_UD11_3;

import java.util.ArrayList;

public class CircularQueue<E> extends ArrayList<E> {  // 'E' representa la classe dels elements del 'CircularArray'
    private final int maxSize;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    // Mètode per afegir un E si la mida de la cua no ha arribat a 'maxSize'
    @Override
    public boolean add(E e) {
        if (this.size() < maxSize)
            return super.add(e);
        else
            return false;
    }

    // Mètode per treure el darrer element i posar-lo al principi
    public void enQueue() {
        if (this.size() > 1) {
            E lastElement = this.remove(this.size() - 1); 
            this.add(0, lastElement); 
        }
    }
    
    // Mètode per treure el primer element i posar-lo al darrer
    public void deQueue() {
        if (this.size() > 1) {
            E firstElement = this.remove(0); 
            this.add(firstElement); 
        }
    }
    
    public boolean offer(E e) {
        return this.add(e);
    }
    
    // Mètode per tornar i eliminar el primer element de la 'CircularQueue'
    public E poll() {
        return super.remove(0);
    }
}