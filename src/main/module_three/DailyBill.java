package main.module_three;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyBill extends Bill{
    public DailyBill(String billCode, LocalDate date, String customer, String roomCode, double price, int amount) {
        super(billCode, date, customer, roomCode, price, amount);
    }

    @Override
    public double revenue() {
        int days = getAmount();
        if (days > 7){
            return getPrice() * (7 + (days - 7) * 80.0 / 100);
        }
        return days * getPrice();
    }

}
