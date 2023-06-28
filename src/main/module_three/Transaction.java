package main.module_three;

import java.time.LocalDate;

public abstract class Transaction {
    private String code;
    private LocalDate date;
    private double price;
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Transaction(String code, LocalDate date, double price, int quantity) {
        this.code = code;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double thanhTien();
}
