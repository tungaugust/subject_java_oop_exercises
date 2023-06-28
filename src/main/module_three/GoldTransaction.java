package main.module_three;

import java.time.LocalDate;

public class GoldTransaction extends Transaction{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GoldTransaction(String code, LocalDate date, double price, int quantity, String type) {
        super(code, date, price, quantity);
        this.type = type;
    }

    @Override
    public double thanhTien() {
        return getQuantity() * getPrice();
    }
}
