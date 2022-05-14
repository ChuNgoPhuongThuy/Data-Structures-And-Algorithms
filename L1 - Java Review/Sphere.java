package JavaReview;

import java.util.Scanner;

public class Sphere {
    static Scanner sc = new Scanner(System.in);
    private double radius;
    private double coordinateX;
    private double coordinateY;
    private double coordinateZ;

    Sphere(){}

    Sphere(double radius, double coordinateX, double coordinateY, double coordinateZ){
        this.radius = radius;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(double coordinateZ) {
        this.coordinateZ = coordinateZ;
    }

    public void input(){
        System.out.println("Nhập bán kính hình cầu: ");
        this.radius = sc.nextDouble();

        System.out.println("Nhập tọa độ x: ");
        this.coordinateX = sc.nextDouble();

        System.out.println("Nhập tọa độ y: ");
        this.coordinateY = sc.nextDouble();

        System.out.println("Nhập tọa độ z: ");
        this.coordinateZ = sc.nextDouble();
    }
}
