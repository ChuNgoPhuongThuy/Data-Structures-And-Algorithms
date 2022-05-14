package Sorting;

import java.util.Scanner;

class Student implements Comparable<Student>{
    static Scanner sc = new Scanner(System.in);
    private int maSV;
    private String name;
    private double score;

    Student(){}

    Student(int maSV, String name, double score){
        this.maSV = maSV;
        this.name = name;
        this.score = score;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void input() {
        System.out.println("Nhập mã sinh viên: ");
        maSV = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sinh viên: ");
        name = sc.nextLine();
        System.out.println("Nhập điểm sinh viên: ");
        score = Double.parseDouble(sc.nextLine());
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }

    public void display(){
        System.out.println("Mã sinh viên: " + maSV);
        System.out.println("Tên sinh viên: " + name);
        System.out.println("Điểm sinh viên: " + score);
    }
}
