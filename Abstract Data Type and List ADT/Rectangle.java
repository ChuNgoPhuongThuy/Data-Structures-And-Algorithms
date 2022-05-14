package hw3_19000311;

public class Rectangle extends Shape {
    private double width = 0;
    private double height = 0;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                "}; " + "Area= " + getArea();
    }

    @Override
    protected double getVolume() {
        return 0;
    }
    @Override
    protected double getArea() {
        return this.width * this.height;
    }
    @Override
    protected double getPerimeter() {
        return (this.width + this.height) * 2;
    }
}
