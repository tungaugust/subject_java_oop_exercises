package main.module_three;

import java.time.LocalDate;

public abstract class Transaction {
    private String code;
    private LocalDate date;
    private double price;
    private int quantity;

    public Transaction(String code, LocalDate date, double price, int quantity) {
        this.code = code;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }
}
