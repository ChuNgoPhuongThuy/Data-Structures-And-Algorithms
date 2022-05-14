package hw2_19000311;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSortProgram2 {
    static Scanner sc = new Scanner(System.in);

    public static <T extends Comparable<T>> void sort(ArrayList<T> list, int n) {
        for (int i = list.size() - 1;  i >= 1 ; --i) {
            int minIndex = i;
            for (int j = 0; j < i; ++j) {
                if (list.get(j).compareTo(list.get(minIndex)) > 0) {
                    minIndex = j;
                }
            }
            T temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
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
