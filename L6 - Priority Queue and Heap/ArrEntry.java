package PriorityQueueAndHeap;

public class ArrEntry<K, E> implements Entry<K, E> {
    K key;
    E element;
    public ArrEntry(K k, E e) {
        this.key = k;
        this.element = e;
    }

    public K getKey() {
        return this.key;
    }

    public E getValue() {
        return this.element;
    }
}

