package main.module_three;

import java.time.LocalDate;

public abstract class KhachHang {
    private String code;
    private String name;
    private LocalDate date;
    private int amount;
    private double price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public KhachHang(String code, String name, LocalDate date, int amount, double price) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.price = price;
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        return "KhachHang{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                String.format(", price=%.3f", getPrice()) +
                '}';
    }
}
