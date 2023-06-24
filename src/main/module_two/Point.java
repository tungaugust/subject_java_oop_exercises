package main.module_two;

public class Point {
    // X and y coordinates
    // the horizontal and vertical addresses
    // a point in any two-dimensional (2D) space
    private String pointLabel;
    private double coordinateX;
    private double coordinateY;

    public Point() {
        this.pointLabel = "O";
        this.coordinateX = 0.0;
        this.coordinateY = 0.0;
    }

    public Point(String pointLabel, double coordinateX, double coordinateY) {
        setPointLabel(pointLabel);
        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);
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

    public String getPointLabel() {
        return pointLabel;
    }

    public void setPointLabel(String pointLabel) {
        this.pointLabel = pointLabel;
    }

    @Override
    public String toString() {
        return String.format("%s(%.2f,%.2f)", pointLabel, coordinateX, coordinateY);
    }
}
