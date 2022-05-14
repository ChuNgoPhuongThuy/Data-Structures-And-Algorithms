package hw1_19000311;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayProgram {
    static Scanner sc = new Scanner(System.in);

    //nhập giá trị phần tử vào mảng
    public ArrayList<Integer> inputElement(ArrayList<Integer> t, int n){
        for (int i = 0 ; i < n; i++ ){
            t.add(sc.nextInt());
        }
        return t;
    }

    //Kiểm tra 1 số có là số nguyên tố không
    public  boolean isPrime(int x){
        if (x < 2) return false;
        for (int i = 2; i < (x - 1); i++){
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    //In ra các số nguyên tố trong list
    public void outputPrime(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++){
            if (isPrime(list.get(i))) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    //In ra các số chẵn trong list
    public void outputEvenNumber(ArrayList<Integer> list){
        for (int i = 0 ; i < list.size(); i++){
            if (list.get(i) % 2 == 0){
                System.out.print(list.get(i) + " ");
            }
        }
    }




    public static void main(String[] args){
        System.out.println("---Làm việc với mảng số nguyên---");
        ArrayProgram test = new ArrayProgram();
        System.out.println("Số phần tử của mảng: ");
        int n = sc.nextInt();

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println("Nhập các phần tử vào mảng: ");
        test.inputElement(list1, n);

        System.out.print("Các số nguyên tố trong mảng: ");
        test.outputPrime(list1);

        System.out.print("\nCác số chẵn trong mảng: ");
        test.outputEvenNumber(list1);

        System.out.println("\n---Làm việc với mảng phần tử có kiểu dữ liệu khác số nguyên--- ");
        ArrayList<House> list = new ArrayList<>();
        System.out.println("Số nhà cần nhập: ");
        int count = sc.nextInt();

        for (int i = 0 ; i < count; i++){
            House house = new House();
            house.input();
            list.add(house);
        }

        System.out.println("Hiển thị thông tin n ngôi nhà: ");
        for (int i = 0 ; i < list.size(); i++){
            list.get(i).display();
        }

    }
}
