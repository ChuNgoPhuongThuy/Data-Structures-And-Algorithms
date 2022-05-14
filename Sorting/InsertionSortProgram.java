package hw2_19000311;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortProgram {
    static Scanner sc = new Scanner(System.in);
    public static void input(ArrayList<Integer> list, int n){
        for (int i = 0 ; i < n; i++){
            System.out.println("Nhập phần tử thứ " + (i + 1) + ": ");
            list.add(Integer.parseInt(sc.nextLine()));
        }
    }

    public static void sort(ArrayList<Integer> list){
        for (int i = 1;  i < list.size(); ++i) {
            int next = list.get(i);
            int j;

            for (j = i - 1; j >= 0 && list.get(j) > next; --j) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, next);

            for (int a = 0 ; a < list.size(); a++){
                System.out.print(list.get(a) + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        System.out.println("Nhập số phần tử của mảng: ");
        int size = Integer.parseInt(sc.nextLine());
        input(list, size);

        sort(list);
        System.out.println("Mảng đã được sắp xếp là: ");
        for (int a = 0 ; a < list.size(); a++){
            System.out.print(list.get(a) + " ");
        }
    }
}
