package hw3_19000311;

public class Sphere extends Shape {
    private double radius = 0;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                "}; " + "Area= " + getArea();
    }

    @Override
    protected double getVolume() {
        return (4 / 3) * 3.14 * (this.radius * this.radius);
    }
    @Override
    protected double getArea() {
        return 4 * 3.14 * (this.radius * this.radius);
    }
    @Override
    protected double getPerimeter() {
        return radius;
    }
}
