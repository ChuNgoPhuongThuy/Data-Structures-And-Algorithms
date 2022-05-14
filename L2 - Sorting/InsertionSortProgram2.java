package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortProgram2 {
    static Scanner sc = new Scanner(System.in);

    public static <T extends Comparable<T>> void sort(ArrayList<T> list, int n) {
        for (int i = 1;  i < list.size(); ++i) {
            T next = list.get(i);
            int j;

            for (j = i - 1; j >= 0 && list.get(j).compareTo(next) > 0; --j) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, next);
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
