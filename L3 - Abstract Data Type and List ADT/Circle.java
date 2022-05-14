package hw3_19000311;

public class Circle extends Shape {
    private double radius = 0;

    // Hàm khởi tạo
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "}; " + "Area= " + getArea();
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return 3.14 * (this.radius * this.radius);
    }


    @Override
    protected double getPerimeter() {
        return 2 * 3.14 * this.radius;
    }
}
