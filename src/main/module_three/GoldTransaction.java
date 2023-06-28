package main.module_three;

import java.time.LocalDate;

public class GoldTransaction extends Transaction{
    private String type;

    public GoldTransaction(String code, LocalDate date, double price, int quantity, String type) {
        super(code, date, price, quantity);
        this.type = type;
    }
}
