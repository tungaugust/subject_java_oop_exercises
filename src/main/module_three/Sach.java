package main.module_three;

import java.time.LocalDate;
import java.util.Locale;

public abstract class Sach {
    private String code;
    private LocalDate importDate;
    private double price;
    private int quantity;
    private String publisher;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Sach(String code, LocalDate importDate, double price, int quantity, String publisher) {
        this.code = code;
        this.importDate = importDate;
        this.price = price;
        this.quantity = quantity;
        this.publisher = publisher;
    }
    public abstract double thanhTien();
}
