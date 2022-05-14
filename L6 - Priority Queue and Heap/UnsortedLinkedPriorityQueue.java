package PriorityQueueAndHeap;


public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {

    protected static class NodeEntry<K,E>implements Entry<K, E> {

        K key;
        E element;

        NodeEntry<K, E> next;

        public  NodeEntry(K k, E e){
            this.key = k;
            this.element = e;
            this.next = null;
        }
        public NodeEntry() {
            // TODO Auto-generated constructor stub
        }



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

    private NodeEntry<K,E> head;
    private NodeEntry<K,E> tail;
    int size = 0;

    public UnsortedLinkedPriorityQueue() {
        // TODO Auto-generated constructor stub

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public void insert(Entry entry) {
        // TODO Auto-generated method stub
        if(head == null) {
            head = new NodeEntry(entry.getKey(),entry.getValue());
            tail = head;
            size=1;

        }
        else {

            NodeEntry last = new NodeEntry(entry.getKey(), entry.getValue());
            tail.next = last;
            tail = last;
            size++;

        }
    }

    @Override
    public void insert(Object k, Object e) {
        // TODO Auto-generated method stub
        if(head == null) {
            head = new NodeEntry(k,e);
            tail = head;
            size=1;

        }
        else {

            NodeEntry last = new NodeEntry(k,e);
            tail.next = last;
            tail = last;
            size++;

        }

    }

    @Override
    public Entry removeMin() {
        // TODO Auto-generated method stub
        if(head == null) {
            System.out.println("Has nothing!");
            return null;
        }
        else if(size == 1) {
           NodeEntry min = head;
            head = null;
            return  min;
        }
        else {

            NodeEntry beforeMin = head;
            NodeEntry min = head;
           NodeEntry temp = min;

            for (int i = 1; i < size; i++) {

                if((int)min.getKey() > (int)temp.next.getKey()) {
                    min = temp.next;
                    beforeMin= temp;
                }
                temp = temp.next;

            }
            beforeMin.next = min.next;
            size--;
            if((int)min.getKey() == (int)head.getKey()) {
                head = min.next;
                return min;
            }
            else {
                return min;
            }

        }
    }

    @Override
    public Entry min() {
        // TODO Auto-generated method stub
        if(head == null) {
            return null;
        }
        else if(size ==1) {
            NodeEntry min = head;
            head = null;
            return min;
        }
        else {
            NodeEntry min = head;
           NodeEntry temp = min;

            for (int i = 1; i < size; i++) {

                if((int)min.getKey() > (int)temp.next.getKey()) {
                    min = temp.next;

                }
                temp = temp.next;

            }
            return min;

        }
    }



}

