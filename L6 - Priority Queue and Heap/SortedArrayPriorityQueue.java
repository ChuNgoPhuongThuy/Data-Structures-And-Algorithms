package PriorityQueueAndHeap;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    protected static class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry (K k, E e){
            this.element = e;
            this.key = k;
        }

        public ArrEntry() {}

        @Override
        public K getKey() {
            // TODO Auto-generated method stub
            return key;
        }

        @Override
        public E getValue() {
            // TODO Auto-generated method stub
            return element;
        }
    }

    ArrEntry<K, E>[] array;
    int top = 0;
    int size = 0;
    int defaultsize = 1000;

    public SortedArrayPriorityQueue(int capacity){
        array = new ArrEntry[capacity];
    }
    public SortedArrayPriorityQueue(){
        array = new ArrEntry[defaultsize];
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size==0;
    }

    @Override
    public void insert(Entry entry) {
        // TODO Auto-generated method stub
        if(size == array.length) {
            System.out.println("Array is full");
        }
        else if(size == 0) {
            K k = (K) entry.getKey();
            E e = (E) entry.getValue();
            array[0] = new ArrEntry(k,e);
            size++;
        }
        else {
            K k = (K) entry.getKey();
            E e = (E) entry.getValue();

            ArrEntry c = new ArrEntry<K, E>(k, e);

            for (int i = top; i < top + size; i++) {

                if((int)c.getKey() < (int)array[i% array.length].getKey()) {
                    for (int j = size + top; j >= i; j--) {
                        array[(j+1) % array.length] = array[j% array.length];
                    }
                    array[i% array.length] = c;
                    break;
                }
                else if(i == size+top-1) {
                    array[size % array.length] = c;
                }
            }
            size++;
        }
    }

    @Override
    public void insert(Object k, Object e) {
        // TODO Auto-generated method stub
        if(size == array.length) {
            System.out.println("Array is full");
        }
        else if(size == 0) {
            array[0] = new ArrEntry(k,e);
            size++;
        }
        else {
            ArrEntry c = new ArrEntry(k, e);
            for (int i = top; i < top + size; i++) {
                if((int)c.getKey() < (int)array[i%array.length].getKey()) {
                    for (int j = size+top; j >= i; j--) {
                        array[(j+1)%array.length] = array[j%array.length];
                    }
                    array[i%array.length] = c;
                    break;
                }
                else if(i == size+top-1) {
                    array[size%array.length] = c;
                }
            }
            size++;}
    }

    @Override
    public Entry removeMin() {
        // TODO Auto-generated method stub
        if(size == 0) {
            System.out.println("Not thing to remove!");
            return null;
        }
        else {
            Entry entry = (Entry) array[top];
            array[top] = null;
            top =(top+1) % array.length;
            size--;
            return entry;
        }
    }

    @Override
    public Entry min() {
        // TODO Auto-generated method stub
        return (Entry) array[top];
    }

    public void setInt(K k,E e) {
        array[size] = new ArrEntry(k,e);
        size++;
    }
}
