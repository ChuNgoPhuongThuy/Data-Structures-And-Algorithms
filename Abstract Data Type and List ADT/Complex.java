package hw3_19000311;

import java.util.ArrayList;
import java.util.Scanner;

public class Complex {
    static Scanner sc = new Scanner(System.in);
    private float real; //phần thực
    private float image; //phần ảo

    // Hàm khởi tạo
    public Complex(float r, float i) {
        this.real = r;
        this.image = i;
    }

    Complex(){}

    // Hoàn thành hàm cộng số phức hiện tại với số phức c
    public Complex add(Complex c) {
        Complex result = new Complex();
        result.real = this.real + c.real;
        result.image = this.image + c.image;
        return result;
    }

    // Hoàn thành hàm trừ số phức hiện tại cho số phức c
    public Complex minus(Complex c) {
        Complex result = new Complex();
        result.real= this.real - c.real;
        result.image = this.image - c.image;
        return result;
    }

    // Hoàn thành hàm nhân số phức hiện tại với số phức c
    public Complex time(Complex c) {
        Complex result = new Complex(this.real, this.image);
        result.real = this.real * c.real - this.image * c.image;
        result.image = this.real * c.image + c.real * this.image;
        return result;
    }

    public float realpart() {
        return real;
    }

    public float imagepart() {
        return image;
    }

    public void input(){
        System.out.println("Nhập phần thực: ");
        this.real = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập phần ảo: ");
        this.image = Float.parseFloat(sc.nextLine());
    }

    @Override
    // Hoàn thành hàm in ra số phức dạng a + bi
    public String toString() {
        return this.real + " + " + this.image + "i";
    }

    public static void main(String[] args) {
        ArrayList<Complex> list = new ArrayList<>();

        System.out.println("Số số phức trong dãy: ");
        int n = Integer.parseInt(sc.nextLine());

        //Nhập số phức vào dãy
        for (int i = 0 ; i < n ; i++){
            System.out.println("Nhập số phức thứ " + (i + 1) + ": ");
            Complex complex = new Complex();
            complex.input();
            list.add(complex);
        }

        System.out.println("Vị trí số phức cần tìm: ");
        int v = Integer.parseInt(sc.nextLine());
        if (v > n || v < 1) {
            System.out.println("Không có số phức nào");
        }
        else {
            System.out.print("Số phức trong vị trí thứ " + v + " là: ");
            System.out.println(list.get(v - 1). toString());
        }

        System.out.println("Tổng các số phức có trong dãy: ");
        Complex sum = new Complex(0, 0);
        for(int i = 0 ; i < n ; i++){
            sum = sum.add(list.get(i));
        }
        System.out.println(sum.toString());

        System.out.println("Tích các số phức có trong dãy: ");
        Complex time = new Complex(1, 0);
        for (int i = 0 ; i < n ; i++){
            time = time.time(list.get(i));
        }
        System.out.println(time.toString());
    }
}
