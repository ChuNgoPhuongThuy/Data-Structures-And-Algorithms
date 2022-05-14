package hw1_19000311;

import java.util.Scanner;

public class ComplexNumber {
    Scanner sc = new Scanner(System.in);
    double real, img;

    ComplexNumber(){
    }

    ComplexNumber(double r, double i){
        this.real = r;
        this.img = i;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public void input(){
        System.out.println("Nhập phần thực của số phức: ");
        real = sc.nextInt();
        System.out.println("Nhập phần ảo của số phức: ");
        img = sc.nextInt();
    }
}
