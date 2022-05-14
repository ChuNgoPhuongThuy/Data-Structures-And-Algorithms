package JavaReview;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class SphereProgram {
    static Scanner sc = new Scanner(System.in);
    static final double PI = 3.14;

    //Tính diện tích xung quanh
    public static double surfaceArea(double r) {
        return 4 * PI * r * r;
    }

    //Tính thể tích
    public static double volume(double r) {
        return ((4.0 / 3.0) * PI * (r * r * r));
    }

    //tính khoảng cách 1 tâm của 2 hình cầu
    public static double distance(double x, double y, double z, double x1, double y1, double z1) {
        return Math.abs(Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1) + (z - z1) * (z - z1)));
    }

    //xét trường hợp giao nhua, bao nhau của hình cầu
    public static void sphereProgram(double r1, double r2, double d) {
        if (r1 + r2 < d && d + Math.min(r1, r2) > Math.max(r1, r2)) {
            System.out.println("Hai hình cầu không giao nhau");
        } else if (r1 + r2 == d) {
            System.out.println("Hai hình cầu tiếp xúc nhau");
        } else if (d + Math.min(r1, r2) < Math.max(r1, r2)) {
            System.out.println("hai hình cầu bao nhau");
        } else if (Math.abs(r1 - r2) < d && d < r1 + r2) {
            System.out.println("Hai hình cầu giao nhau");
        }
        else {
            System.out.println("Hai hình cầu đồng tâm");
        }

    }

    public static void main(String[] args){

        ArrayList<Sphere> list = new ArrayList<>();
        for (int i = 0 ; i < 2; i++){
            Sphere sphere = new Sphere();
            sphere.input();
            list.add(sphere);
        }

        double d = distance(list.get(0).getCoordinateX(), list.get(0).getCoordinateY(), list.get(0).getCoordinateZ(), list.get(1).getCoordinateX(), list.get(1).getCoordinateY(), list.get(1).getCoordinateZ() );

        System.out.println("Diện tích mặt cầu thứ nhất: " + surfaceArea(list.get(0).getRadius()));
        System.out.println("Diện tích mặt cầu thứ hai: " + surfaceArea(list.get(1).getRadius()));
        System.out.println("Thể tích hình cầu thứ nhất: " + volume(list.get(0).getRadius()));
        System.out.println("Thể tích hình cầu thứ hai: " + volume(list.get(1).getRadius()));
        sphereProgram(list.get(0).getRadius(), list.get(1).getRadius(),d);
    }
}
