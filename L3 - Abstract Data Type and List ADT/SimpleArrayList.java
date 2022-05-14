package hw3_19000311;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        // Hàm dựng với kích thước mảng là capacity
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        // Hoàn thành thân hàm}
        for(int i = 0 ; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = data;
                break;
            }
        }
    }
    public T get ( int i){
        // Hoàn thành thân hàm
        return array[i];
    }
    public void set ( int i, T data){
        // Hoàn thành thân hàm
        array[i] = data;
    }
    public void remove (T data){
        // Hoàn thành thân hàm
        for(int i = 0 ; i < array.length - 1; i++) {
            if (array[i] == data) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
    }
    public boolean isContain (T data){
        // Hoàn thành thân hàm
        boolean test = false;
        for (int  i = 0 ; i < array.length; i++) {
            if (array[i] == data) {
                test = true;
            }
        }
        return test;
    }
    public int size () {
        // Hoàn thành thân hàm
        int size = 0;
        for(int i = 0 ; i < array.length; i++){
            if (array[i] != null){
                size ++;
            }
        }
        return size;
    }
    public boolean isEmpty () {
        // Hoàn thành thân hàm
        return size() == 0;
    }
    public Iterator<T> iterator () {
        //Trả về toàn bộ danh sách
        // Hoàn thành thân hàm

        return new Iter();
    }

    private class Iter implements Iterator<T>{
        int index = -1;

        Iter(){}

        @Override
        public boolean hasNext() {
            index ++;
            return index < size();
        }

        @Override
        public T next() {
            return array[index];
        }
    }

}

