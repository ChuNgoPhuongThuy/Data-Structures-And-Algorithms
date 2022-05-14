package hw3_19000311;

import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapeProgram {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<>();
        int n = 3;
        list.add(new Rectangle(2, 3));
        list.add(new Circle(2));
        list.add(new Sphere(3));

        System.out.println(list.get(0).toString() + "; Perimeter= " + list.get(0).getPerimeter());
        System.out.println(list.get(1).toString() + "; Perimeter= " + list.get(1).getPerimeter());
        System.out.println(list.get(2).toString() + "; Volume= " + list.get(2).getVolume());
    }
}
