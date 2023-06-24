package main.module_two;

public class Circle {
    private Point center;
    private double radius;

    public Circle() {
        this.center = new Point();
        this.radius = 1.0;
    }

    public Circle(Point center, double radius) {
        setCenter(center);
        setRadius(radius);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0.0) {
            radius = 1.0;
        }
        this.radius = radius;
    }

    public double perimeter() {
        return Math.PI * 2 * getRadius();
    }

    public double surfaceArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}
