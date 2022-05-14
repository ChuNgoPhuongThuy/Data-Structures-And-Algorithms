package hw1_19000311;

import java.util.Scanner;

public class House  {
    Scanner sc = new Scanner(System.in);
    private String soNha;
    private String diaChi;
    private String loaiNha;

    House(){}
    House(String soNha, String diaChi, String loaiNha){
        this.soNha = soNha;
        this.diaChi = diaChi;
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public void input() {
        System.out.println("Nhập số nhà: ");
        soNha = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        diaChi = sc.nextLine();
        System.out.println("Nhập loại nhà: ");
        loaiNha = sc.nextLine();
    }

    public void display() {
        System.out.println("Số nhà: " + soNha);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Loại nhà: " + loaiNha);
    }
}

