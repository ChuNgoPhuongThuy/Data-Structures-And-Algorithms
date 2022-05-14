package StackAndQueueADT;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000; // default array capacity
    private E[] array;
    private int topIndex = -1; // index of the top element in stack

    public ArrayStack(){}

    public ArrayStack(int capacity){
        array = (E[]) new Object[capacity];
    }

    public int size(){
        return (topIndex + 1);
    }

    //thêm một phần tử vào đầu danh sách
    @Override
    public void push(E element) {
        if (size() == array.length){
            System.out.println("Stack is full");
        }
        array[++topIndex] = element;
    }

    //lấy phần tử đầu của danh sách và trả về giá trị của phần tử đó
    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        E data = array[topIndex];
        array[topIndex] = null;
        topIndex--;
        return data;
    }

    //kiểm tra danh sách có rỗng hay không
    @Override
    public boolean isEmpty() {
        return (topIndex == -1);
    }

    //trả về phẩn tử đầu của danh sách
    @Override
    public E top() {
        if (isEmpty()){
            return null;
        }
        return array[topIndex];
    }

    //trả về toàn bộ danh sách
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E>{
        int index = -1;

        Iter(){}

        @Override
        public boolean hasNext() {
            index ++;
            return index < size();
        }

        @Override
        public E next() {
            return array[index];
        }
    }
}
