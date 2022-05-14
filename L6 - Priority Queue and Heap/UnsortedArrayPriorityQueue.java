package PriorityQueueAndHeap;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
        @Override
        public int size() {
                return size;
        }

        @Override
        public boolean isEmpty() {
                return size() == 0;
        }

        @Override
        public void insert(Entry entry) {
                if (size() == array.length){
                        System.out.println("Array is full!");
                } else {
                        K k = (K) entry.getKey();
                        E e = (E) entry.getValue();
                        array[size] = new ArrEntry(k, e);
                        size++;
                }

        }

        @Override
        public void insert(Object o, Object o2) {
                if (size() == array.length){
                        System.out.println("Array is full!");
                } else {
                        array[size] = new ArrEntry(o, o2);
                        size++;
                }
        }

        @Override
        public Entry removeMin() {
                if(isEmpty()){
                        return null;
                } else {
                        int minindex = 0;
                        //Tìm index nhỏ nhất
                        for (int i = 1; i < size-1; i++) {
                                if((int)array[minindex].getValue() > (int)array[i].getValue()) {
                                        minindex = i;
                                }
                        }
                        Entry a  = array[minindex];
                        //cập nhật index
                        for(int i = minindex ;i <array.length-1;i++) {
                                array[i] = array[i+1];
                        }
                        size--;
                        return a;
                }
        }

        @Override
        public Entry min() {
                if(isEmpty()){
                        return null;
                }
                else {
                        int minindex = 0;
                        //Tìm index nhỏ nhất
                        for (int i = 1; i < size-1; i++) {
                                if((int)array[minindex].getKey() > (int)array[i].getKey()) {
                                        minindex = i;
                                }
                        }
                        return array[minindex];
                }
        }

        public class ArrEntry<K, E> implements Entry<K, E>{
                K key;
                E element;
                public ArrEntry (K k, E e){
                        this.key = k;
                        this.element = e;
                }
                public ArrEntry(){}

                @Override
                public K getKey() {
                        return key;
                }

                @Override
                public E getValue() {
                        return element;
                }
        }

        int n = 0;
        int size = 0;
        int defaultsize = 1000;
        ArrEntry<K, E> [] array;
        public UnsortedArrayPriorityQueue(int capacity){
                array = new ArrEntry[capacity];
        }
        public UnsortedArrayPriorityQueue(){
                array = new ArrEntry[defaultsize];
        }
}
