package StackAndQueueADT;

import hw4_19000311.LinkedListStack;
import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {

    public static boolean test(String s){
        LinkedListStack <Character> stack = new LinkedListStack<>();

        for (int i = 0; i < s.length(); i++){
            char x = s.charAt(i);

            if (x == '('){
                stack.push(x);
            }
            else if (x == ')'){
                if (!stack.isEmpty()) {
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        return (stack.isEmpty());
    }


    public static int priority(char c){
        if (c == '+' || c == '-'){
            return 1;
        }
        else if (c == '*' || c == '/'){
            return 2;
        }
        else return 0;
    }

    public static boolean isOperator(char c){
        char [] operator = {'+' , '-' , '*' , '/' , '(' , ')'};
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1){
            return true;
        }
        else {
            return false;
        }
    }

    public static String postFix(String[] s){
        Stack <String> stack = new Stack<String>();
        String s1 = "";

        for (int i = 0 ; i < s.length; i++){
            char c = s[i].charAt(0);
            if (!isOperator(c)){
                s1 = s1 + " " + s[i];
            }
            else {
                if (c == '('){
                     stack.push(s[i]);
                } else {
                    if (c == ')'){
                        char c1;
                        do {
                            c1 = stack.peek().charAt(0);
                            if (c1 != '('){
                                s1 = s1 + " " + stack.peek();
                            }
                            stack.pop();
                        } while (c1 != '(');
                    } else {
                        while (!stack.isEmpty() && priority(stack.peek().charAt(0)) >= priority(c)){
                            s1 = s1 + " " + stack.peek();
                            stack.pop();
                        }
                        stack.push(s[i]);
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            s1 = s1 + " " + stack.peek();
            stack.pop();
        }
        s1 = s1.replaceAll("\\s", "");

        return s1;
    }


    public static String[] process(String s){
        String s1 = "";
        String[] result = null;
        s = s.trim();
        s = s.replaceAll("\\s", "");

        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if (!isOperator(c)){
                s1 = s1 + c;
            } else {
                s1 = s1 + " " + c + " ";
            }
        }

        s1 = s1.trim();
        s1 = s1.replaceAll("\\s", "");
        result = s1.split("");
        return result;
    }

    public static int calculator(String s){
        Stack <Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                stack.push(c - '0');
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (c){
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String sMath, elementMath[] = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập biểu thức với các toán tử là +, -, *, / : ");
        sMath = input.nextLine();
        System.out.println("Biểu thức có hợp lệ về dấu ngoặc không: " + test(sMath));
        if (test(sMath)) {
            System.out.println(postFix(process(sMath)));
            System.out.print("Giá trị biểu thức là: ");
            System.out.println(calculator(postFix(process(sMath))));
        } else {
            System.out.println("Biểu thức không hợp lệ");
        }
    }
}
