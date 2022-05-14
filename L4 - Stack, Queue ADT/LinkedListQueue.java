package hw4_19000311;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node{
        E element;
        Node next;
        Node (E data){
            this.element = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    @Override
    public void enqueue(E element) {
        Node newNode = new Node(element);
        if (tail == null){
            head = tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;

    }

    @Override
    public E dequeue() {
        if (this.head == null){
            return null;
        }

        Node temp = this.head;
        this.head = this.head.next;

        if (this.head == null){
            this.tail = null;
        }

        return temp.element;
    }

    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<E> {
        private Node headNode = head;
        private Node tailNode = tail;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return headNode == tailNode;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            E data = headNode.element;
            headNode = headNode.next;
            return data;
        }
    }
}
