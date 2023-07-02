package main.module_three;

import java.text.DecimalFormat;

public class Car extends Vehicle{
    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Car(String brand, String manufacturer, String serialNumber, int manufactureYear, String owner, double price, int seatCount) {
        super(brand, manufacturer, serialNumber, manufactureYear, owner, price);
        this.seatCount = seatCount;
        this.setRegistrationTax(0.2);
        if (getSeatCount() >= 5){
            this.setExciseTax(0.3);
        } else {
            this.setExciseTax(0.5);
        }
    }

    @Override
    public double tax() {
        return getPrice() * (getVatTax() + getRegistrationTax() + getExciseTax());
    }

    @Override
    public double revenue() {
        return getPrice() + tax();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00 VND");
        String type =  "Xe oto khach";
        String record = String.format("%-30s %-30s %15s %15d %-25s %25s %25s %-20s %-20s"
                , getBrand()
                , getManufacturer()
                , getSerialNumber()
                , getManufactureYear()
                , getOwner()
                , decimalFormat.format(getPrice())
                , decimalFormat.format(revenue())
                , type
                , String.valueOf(getSeatCount()) + " seats"
        );
        return record;
    }
}
