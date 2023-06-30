package main.module_three;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Bill {
    private String billCode;
    private LocalDate date;
    private String customer;
    private String roomCode;
    private double price;
    private int amount;

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Bill(String billCode, LocalDate date, String customer, String roomCode, double price, int amount) {
        this.billCode = billCode;
        this.date = date;
        this.customer = customer;
        this.roomCode = roomCode;
        this.price = price;
        this.amount = amount;
    }

    public abstract double revenue();

    public static String headerLine(){
        return String.format("%-15s %-20s %-25s %-15s %20s %10s %20s"
                , "MA HD", "NGAY XUAT HD", "TEN KHACH HANG", "MA PHONG", "DON GIA", "SO LUONG", "THANH TIEN"
        );
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFString = getDate().format(dtf);

        DecimalFormat df = new DecimalFormat("#,##0.00");
        String priceFString = df.format(getPrice()) + "VND";
        String revenueFString = df.format(revenue()) + "VND";

        String record = String.format("%-15s %-20s %-25s %-15s %20s %10s %20s"
                , getBillCode()
                , dateFString
                , getCustomer()
                , getRoomCode()
                , priceFString
                , getAmount()
                , revenue()
        );
        return record;
    }

    @Override
    public boolean equals(Object obj) {
        // Doi tuong so sanh voi chinh no
        if (obj == this){
            return true;
        }
        // Kiem tra cung lop
        if (!(obj instanceof Bill)){
            return false;
        }
        // Typecast obj thanh Bill
        Bill bill = (Bill) obj;
        if (bill.getBillCode().equals(this.getBillCode())){
            return true;
        }
        return false;
    }
}
