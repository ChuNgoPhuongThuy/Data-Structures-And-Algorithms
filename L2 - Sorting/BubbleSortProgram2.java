package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSortProgram2 {
    static Scanner sc = new Scanner(System.in);

    public static <T extends Comparable<T>> void sort(ArrayList<T> list, int n) {
        for (int i = 0 ; i < n; ++i){
            boolean isSorted = true;
            for (int j = 1; j < n - i; ++j){
                if (list.get(j - 1).compareTo(list.get(j)) > 0){
                    T temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                    isSorted = false;
                }
            }
            if (isSorted) return;
        }
    }

    public static void main(String[] args) {
        System.out.println("Số phần tử của mảng: ");
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("Nhập các phần tử vào mảng: ");

        for (int i = 0 ; i < n; i++){
            Student student = new Student();
            student.input();
            list.add(student);
        }

        System.out.println("Mảng đã sắp xếp theo tên: ");
        sort(list, n);

        for (int i = 0 ; i < list.size(); i++){
            list.get(i).display();
        }
    }
}
