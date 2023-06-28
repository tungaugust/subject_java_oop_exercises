package main.module_three;

import java.time.LocalDate;

public class CurrencyTransaction extends Transaction{
    private String type;
    private double rate;
    public static final String VND_TYPE = "Dong Vietnam";
    public static final String USD_TYPE = "Dong dola My";
    public static final String EUR_TYPE = "Dong Euro";

    public CurrencyTransaction(String code, LocalDate date, double price, int quantity, String type, double rate) {
        super(code, date, price, quantity);
        this.type = type;
        this.rate = rate;
    }
}
