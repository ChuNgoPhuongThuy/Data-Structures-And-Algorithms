package PriorityQueueAndHeap;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue {

    protected class ArrEntry<K, E> implements Entry<K, E> {
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

    ArrEntry<K, E>[] heapPQ;

    protected MinHeapPriorityQueue() {
        super();
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int left(int i) {
        return (2 * i) + 1;
    }

    protected int right(int i) {
        return (2 * i) + 2;
    }

    protected boolean hasLeft(int i) {
        return left(i) < this.size();
    }

    protected boolean hasRight(int i) {
        return right(i) < this.size();
    }

    protected void upHeap(int i) {
        while (i > 0) {
            int p = parent(i);
            if ((int) heapPQ[i].getKey() >= (int) heapPQ[p].getKey()) {
                break;
            }
            ArrEntry<K, E> temp = heapPQ[i];
            heapPQ[i] = heapPQ[p];
            heapPQ[p] = temp;
            i = p;
        }
    }

    protected void downHeap(int i) {
        while (hasLeft(i)) {
            int leftI = left(i);
            int smallI = leftI;

            if (hasRight(i)) {
                int rightIndex = right(i);
                if ((int) heapPQ[leftI].getKey() > (int) heapPQ[rightIndex].getKey()) {
                    smallI = rightIndex;
                }
            }
            if ((int) heapPQ[smallI].getValue() >= (int) heapPQ[i].getValue()) {
                break;
            }
            // đổi chỗ i và smallI
            ArrEntry<K, E> temp = heapPQ[i];
            heapPQ[i] = heapPQ[smallI];
            heapPQ[smallI] = temp;
            i = smallI;
        }
    }

}

