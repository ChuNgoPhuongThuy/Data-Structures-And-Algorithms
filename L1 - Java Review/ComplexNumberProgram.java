package JavaReview;

import java.util.ArrayList;
import java.util.Scanner;

public class ComplexNumberProgram {
    static Scanner sc = new Scanner(System.in);

    //tính tổng
    public static ComplexNumber sum(ComplexNumber a, ComplexNumber b){
        ComplexNumber resultSum = new ComplexNumber();

        resultSum.setReal(a.getReal() + b.getReal()); ;//phần thực
        resultSum.setImg(a.getImg() + b.getImg());;//phần ảo

        return resultSum;

    }

    //tính tích
    public static ComplexNumber volume(ComplexNumber a, ComplexNumber b){
        ComplexNumber resultVolume = new ComplexNumber();

        resultVolume.setReal(a.getReal() * b.getReal() - a.getImg() * b.getImg()); //phần thực
        resultVolume.setImg(a.getReal() * b.getImg() + a.getImg() * b.getReal());//phần ảo

        return resultVolume;
    }

    public static void main(String[] args){
        ArrayList<ComplexNumber> complexNumbers = new ArrayList<>(); //khởi tạo list chứa các số
        ComplexNumber tempSum = new ComplexNumber(0,0);//biến ghi tạm kết quả tổng
        ComplexNumber temVolume = new ComplexNumber(1,0);//biến ghi tạm kết quả tích
        System.out.println("Số số phức cần nhập: ");
        int count = Integer.parseInt(sc.nextLine());

        //thực hiện tính tổng
        for (int i = 0 ; i < count; i++){
            ComplexNumber complexNumber = new ComplexNumber();
            complexNumber.input();
            complexNumbers.add(complexNumber);
        }

        //thực hiện tính tích
        for (int i = 0; i < complexNumbers.size(); i++){
            tempSum = sum(tempSum, complexNumbers.get(i));
            temVolume = volume(temVolume, complexNumbers.get(i));
        }

        //in kết quả
        System.out.print("Tổng của các số phức là: ");
        System.out.println(tempSum.getReal() + " + " + tempSum.getImg() + "i");

        System.out.print("Tích của các số phức là: ");
        System.out.println(temVolume.getReal() + " + " + temVolume.getImg() + "i");

        int[] list = new int[3];
    }
}
