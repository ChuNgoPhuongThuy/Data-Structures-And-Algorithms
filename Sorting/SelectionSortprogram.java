package hw2_19000311;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSortprogram {
    static Scanner sc = new Scanner(System.in);
    public static void input(ArrayList<Integer> list, int n){
        for (int i = 0 ; i < n; i++){
            System.out.println("Nhập phần tử thứ " + (i + 1) + ": ");
            list.add(Integer.parseInt(sc.nextLine()));
        }
    }

    public static void sort(ArrayList<Integer> list){
        for (int i = list.size() - 1;  i >= 1 ; --i) {
            int minIndex = i;
            for (int j = 0; j < i; ++j) {
                if (list.get(j) > list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
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
