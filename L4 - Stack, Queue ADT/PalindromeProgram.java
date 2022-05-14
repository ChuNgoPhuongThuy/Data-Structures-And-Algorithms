package StackAndQueueADT;

import hw4_19000311.LinkedListQueue;
import java.util.Scanner;

public class PalindromeProgram {
    public static boolean test(String s){
        LinkedListQueue <Character> queue = new LinkedListQueue<>();
       for (int i = s.length() - 1; i >= 0 ; i--){
           queue.enqueue(s.charAt(i));
       }

       String s1 = "";
       while (!queue.isEmpty()){
           s1 = s1 + queue.dequeue();
       }

       if (s.equals(s1)){
           return true;
       } else {
           return false;
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập dãy cần kiểm tra: ");
        String s = sc.nextLine();

        if (test(s)){
            System.out.println("Đây là chuỗi đối xứng");
        } else {
            System.out.println("Đây không là chuỗi đối xứng");
        }
    }
}
