package hw1_19000311;
import java.util.Scanner;

public class InputProgram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int numberInt = sc.nextInt();
        float numberFloat = sc.nextFloat();
        boolean b = sc.nextBoolean();
        long numberLong = sc.nextLong();
        double numberDouble = sc.nextDouble();

        System.out.println("String: " + s);
        System.out.println("Integer: " + numberInt);
        System.out.println("Float: " + numberFloat);
        System.out.println("Boolean: " + b);
        System.out.println("Long: " + numberLong);
        System.out.println("Double: " + numberDouble);
    }
}
