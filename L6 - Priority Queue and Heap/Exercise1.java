package PriorityQueueAndHeap;

import java.util.Scanner;

class Book {
    private String name;
    private int price;
    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String toString() {
        return name + " - " + price;
    }
}

public class Exercise1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book1 = new Book("Toán", 15000);
        Book book2 = new Book("Ngữ văn", 1000);
        Book book3 = new Book("Sinh học", 20000);
        Book book4 = new Book("Lịch sử", 12000);
        Book book5 = new Book("Địa lý", 150000);

        System.out.println("Unsorted Array Priority Queue Test");

        System.out.println("Số nguyên");
        UnsortedArrayPriorityQueue<Integer, Integer> arr = new UnsortedArrayPriorityQueue<Integer, Integer>();

        arr.insert(1,1);
        arr.insert(6,6);
        arr.insert(10,10);
        arr.insert(7,7);

        System.out.println(arr.isEmpty());
        System.out.println(arr.size());
        System.out.println(arr.removeMin().getValue());
        System.out.println(arr.removeMin().getValue());
        System.out.println(arr.size());

        System.out.println("Sách");
        UnsortedArrayPriorityQueue<Integer, Book> unsorted = new UnsortedArrayPriorityQueue<Integer, Book>();
        unsorted.insert(new ArrEntry(book1.getPrice(), book1));
        unsorted.insert((Entry) new ArrEntry(book2.getPrice(), book2));
        unsorted.insert((Entry) new ArrEntry(book3.getPrice(), book3));
        unsorted.insert((Entry) new ArrEntry(book4.getPrice(), book4));
        unsorted.insert((Entry) new ArrEntry(book5.getPrice(), book5));
        System.out.println(unsorted.isEmpty());

        System.out.println("Sorted Array Priority Queue Test");
        SortedArrayPriorityQueue<Integer, Integer> sort = new SortedArrayPriorityQueue<Integer, Integer>();
        System.out.println("Số nguyên");
        sort.insert(0,0);
        sort.insert(2,2);
        sort.insert(6,6);
        sort.insert(1,1);
        System.out.println(sort.isEmpty());
        System.out.println(sort.size());
        System.out.println(sort.removeMin().getValue());
        System.out.println(sort.removeMin().getValue());
        System.out.println(sort.size());

        System.out.println("Sách");
        SortedArrayPriorityQueue<Integer, Book> sorted = new SortedArrayPriorityQueue<Integer, Book>();
        sorted.insert(new ArrEntry(book1.getPrice(), book1));
        sorted.insert(new ArrEntry(book2.getPrice(), book2));
        sorted.insert(new ArrEntry(book3.getPrice(), book3));
        sorted.insert(new ArrEntry(book4.getPrice(), book4));
        sorted.insert(new ArrEntry(book5.getPrice(), book5));
        System.out.println(sorted.isEmpty());
        System.out.println(sorted.removeMin().getValue());

        System.out.println("Unsorted Linked Priority Queue Test");
        System.out.println("Số nguyên");
        UnsortedLinkedPriorityQueue<Integer, Integer> unLinked = new UnsortedLinkedPriorityQueue<>();
        unLinked.insert(9,9);
        unLinked.insert(5,5);
        unLinked.insert(7,7);
        unLinked.insert(10,10);
        System.out.println(unLinked.isEmpty());
        System.out.println(unLinked.size());
        unLinked.removeMin();
        System.out.println(unLinked.size());

        System.out.println("Sách");
        UnsortedLinkedPriorityQueue<Integer, Book> unSortedLinked = new UnsortedLinkedPriorityQueue<>();
        unSortedLinked.insert(new ArrEntry(book1.getPrice(), book1));
        unSortedLinked.insert(new ArrEntry(book2.getPrice(), book2));
        unSortedLinked.insert(new ArrEntry(book3.getPrice(), book3));
        unSortedLinked.insert(new ArrEntry(book4.getPrice(), book4));
        unSortedLinked.insert(new ArrEntry(book5.getPrice(), book5));
        System.out.println(unSortedLinked.size());

        System.out.println("Sorted Linked Priority Queue Test");
        System.out.println("Số nguyên");
        SortedLinkedPriorityQueue<Integer, Integer> linked = new SortedLinkedPriorityQueue<>();
        linked.insert(11,11);
        linked.insert(42,42);
        linked.insert(7,7);
        linked.insert(5,5);
        System.out.println(linked.isEmpty());
        System.out.println(linked.size());
        System.out.println(linked.min().getKey());
        System.out.println(linked.removeMin().getKey());
        System.out.println(linked.size());
        System.out.println(linked.min().getKey());

        System.out.println("Sách");
        SortedLinkedPriorityQueue<Integer, Book> sortedLinked = new SortedLinkedPriorityQueue<>();
        sortedLinked.insert(new ArrEntry(book1.getPrice(), book1));
        sortedLinked.insert(new ArrEntry(book2.getPrice(), book2));
        sortedLinked.insert(new ArrEntry(book3.getPrice(), book3));
        sortedLinked.insert(new ArrEntry(book4.getPrice(), book4));
        sortedLinked.insert(new ArrEntry(book5.getPrice(), book5));
        System.out.println(sortedLinked.size());
    }
}
