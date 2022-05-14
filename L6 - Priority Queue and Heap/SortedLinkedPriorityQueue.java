package PriorityQueueAndHeap;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    protected static class NodeEntry<K,E> implements Entry<K, E> {

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

    public SortedLinkedPriorityQueue() {}

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
            head = new NodeEntry(entry.getKey(), entry.getValue());
            tail = head;
            size = 1;
            //	System.out.println(entry.getValue().toString());
        }
        else {
            NodeEntry beforeMin = head;
            NodeEntry newest = new NodeEntry(entry.getKey(), entry.getValue());
            NodeEntry temp = head;

            for (int i = 0; i < size; i++) {
                if((int)newest.getKey() < (int)temp.getKey()) {
                    if(i == 0) {
                        newest.next = head;
                        head = newest;
                    }
                    else {
                        newest.next = temp;
                        beforeMin.next= newest;
                    }
                    break;
                }
                else if(temp.equals(tail)) {
                    tail.next = newest;
                    tail = newest;
                    break;
                }
                beforeMin = temp;
                temp = temp.next;
            }
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
           NodeEntry beforeMin = head;
           NodeEntry newest = new NodeEntry(k, e);
            NodeEntry temp = head;
            for (int i = 0; i < size; i++) {
                if((int)newest.getKey() < (int)temp.getKey()) {
                    if(i == 0) {
                        newest.next = head;
                        head = newest;
                    }
                    else {
                        newest.next = temp;
                        beforeMin.next= newest;
                    }
                    break;
                }
                else if(temp.equals(tail)) {
                    tail.next = newest;
                    tail = newest;
                    break;
                }
                beforeMin = temp;
                temp = temp.next;
            }
            size++;
        }
    }

    @Override
    public Entry removeMin() {
        // TODO Auto-generated method stub
        NodeEntry min = head;
        head = head.next;
        size--;
        return min;
    }

    @Override
    public Entry min() {
        // TODO Auto-generated method stub
        NodeEntry min = head;
        return (Entry) min;
    }

    public void setInt(K k,E e) {
        if(size == 0) {
            tail = new NodeEntry(k,e);
            head = tail;
        }
        tail.next = new NodeEntry(k,e);
        tail = tail.next;
        size++;
    }
}

