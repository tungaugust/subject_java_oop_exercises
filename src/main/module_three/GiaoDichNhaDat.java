package main.module_three;

import java.time.LocalDate;

public abstract class GiaoDichNhaDat {
    private String code;
    private LocalDate date;
    private double price; // per a square meter
    private String type;
    private double area;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public GiaoDichNhaDat(String code, LocalDate date, double price, String type, double area) {
        this.code = code;
        this.date = date;
        this.price = price;
        this.type = type;
        this.area = area;
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        return "GiaoDichNhaDat{" +
                "code='" + code + '\'' +
                ", date=" + date +
                String.format(", price=%.3f", getPrice()) +
                ", type='" + type + '\'' +
                ", area=" + area +
                '}';
    }
}
