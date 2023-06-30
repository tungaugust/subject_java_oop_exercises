package main.module_three;

import java.time.LocalDate;

public class HourlyBill extends Bill{

    public HourlyBill(String billCode, LocalDate date, String customer, String roomCode, double price, int amount) {
        super(billCode, date, customer, roomCode, price, amount);
    }

    @Override
    public double revenue() throws RuntimeException{
        int hours = getAmount();
        if (hours > 24 && hours < 30) {
            hours = 24;
        }
        if (hours > 30) {
            throw new RuntimeException("So gio thue tren 30 gio, can chuyen sang loai hoa don theo ngay.");
        }
        return hours * getPrice();
    }
}
