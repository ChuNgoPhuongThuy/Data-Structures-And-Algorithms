package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSortProgram {
    static Scanner sc = new Scanner(System.in);
    static int count1 = 0;
    static int count2 = 0;

    public static void input(ArrayList<Integer> list, int n){
        for (int i = 0 ; i < n; i++){
            System.out.println("Nhập phần tử thứ " + (i + 1) + ": ");
            list.add(Integer.parseInt(sc.nextLine()));
        }
    }

    public static void sort(ArrayList<Integer> list){
        for (int i = 0 ; i < list.size(); ++i){
            boolean isSorted = true;
            for (int j = 1; j < list.size() - i; ++j){
                count1 += 1;
                if (list.get(j - 1) > list.get(j)){
                    int temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                    isSorted = false;
                    count2 += 1;
                }
                for (int a = 0 ; a < list.size(); a++){
                    System.out.print(list.get(a) + " ");
                }
                System.out.println("\n");
            }
            if (isSorted) return;
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

        System.out.println("\nSố lần so sánh: " + count1);
        System.out.println("Số lần đổi chỗ: " + count2);
    }
}
