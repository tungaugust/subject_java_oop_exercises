package main.module_three;

import java.time.LocalDate;

public class CurrencyTransaction extends Transaction{
    private String type;
    private double rate; // currency conversion rate or tax
    public static final String VND_TYPE = "Dong Vietnam";
    public static final String USD_TYPE = "Dong dola My";
    public static final String EUR_TYPE = "Dong Euro";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public CurrencyTransaction(String code, LocalDate date, double price, int quantity, String type, double rate) {
        super(code, date, price, quantity);
        this.type = type;
        this.rate = rate;
    }

    @Override
    public double thanhTien() {
        if (getType().equals(USD_TYPE) || getType().equals(EUR_TYPE)){
            return getPrice() * getQuantity() * getRate();
        }
        if (getType().equals(VND_TYPE)){
            return getPrice() * getQuantity();
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "code='" + getCode() + '\'' +
                ", date=" + getDate() +
                String.format(", price=%.3f", getPrice()) +
                ", quantity=" + getQuantity() +
                ", type='" + getType() + '\'' +
                ", rate='" + getRate() +
                String.format(", total=%.3f", thanhTien()) +
                '}';
    }
}
