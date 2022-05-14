package StackAndQueueADT;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
        Node (E data){
            this.element = data;
        }
    }
    private Node stack = null;

    @Override
    public void push(E element) {
    // Thêm một phần tử vào stack
        Node newNode = new Node(element);

        if (stack == null){
            stack = newNode;
        }
        else {
            Node temp = stack;
            stack = newNode;
            stack.next = temp;
        }
    }
    @Override
    public E pop() {
    // Lấy một phần tử khỏi stack
        E data;
        if (stack == null){
            return null;
        }
        else {
            data = stack.element;
            stack = stack.next;
        }
        return data;
    }
    @Override
    public boolean isEmpty() {
    // Kiểm tra stack rỗng
        if (stack == null){
            return true;
        }
        return false;
    }
    @Override
    public E top() {
    // Lấy giá trị phần tử đầu tiên của stack
        if (stack == null){
            System.out.println("Stack is empty");
            return null;
        }
        else {
            return stack.element;
        }
    }

    @Override
    public Iterator<E> iterator() {
    // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
        // TODO Auto-generated method stub
            return currentNode != null;
        }

        @Override
        public E next() {
        // TODO Auto-generated method stub
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
