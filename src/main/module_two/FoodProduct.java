package main.module_two;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FoodProduct {
    private String code;
    private String name;
    private double price;
    private LocalDate manufactureDay;
    private LocalDate expirationDay;

    public FoodProduct(String code) {
        setCode(code);
    }

    public FoodProduct(String code, String name, double price, LocalDate manufactureDay, LocalDate expirationDay) {
        this(code);
        setName(name);
        setPrice(price);
        setManufactureDay(manufactureDay);
        setExpirationDay(expirationDay);
    }

    private String getCode() {
        return code;
    }

    private void setCode(String code) throws RuntimeException {
        if (code.equals("")) {
            throw new RuntimeException("Code is not allowed that is the empty string.");
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            name = "xxx";
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0.0) {
            price = 0;
        }
        this.price = price;
    }

    public LocalDate getManufactureDay() {
        return manufactureDay;
    }

    public void setManufactureDay(LocalDate manufactureDay) {
        if (manufactureDay.isAfter(LocalDate.now())) {
            manufactureDay = LocalDate.now();
        }
        this.manufactureDay = manufactureDay;
    }

    public LocalDate getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(LocalDate expirationDay) {
        if (expirationDay.isBefore(this.manufactureDay)) {
            expirationDay = this.manufactureDay;
        }
        this.expirationDay = expirationDay;
    }

    public boolean isExpirated() {
        if (this.expirationDay.isBefore(LocalDate.now())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        //Trong đó: định dạng đơn giá có phân cách hàng nghìn; định dạng kiểu ngày là dd/MM/yyyy
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String fprice = df.format(this.price) + "VND";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String manufactureDay = this.manufactureDay.format(dtf);
        String expirationDay = this.expirationDay.format(dtf);
        String note = isExpirated() ? "Hang het han" : "";
        String record = String.format("%-15s %-20s %30s %20s %20s %25s"
                , getCode()
                , getName()
                , fprice
                , manufactureDay
                , expirationDay
                , note
        );
        return record;
    }
}
