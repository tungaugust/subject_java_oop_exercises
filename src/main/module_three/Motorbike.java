package main.module_three;

import java.text.DecimalFormat;

public class Motorbike extends Vehicle{
    public Motorbike(String brand, String manufacturer, String serialNumber, int manufactureYear, String owner, double price) {
        super(brand, manufacturer, serialNumber, manufactureYear, owner, price);
        this.setRegistrationTax(0.1);
    }

    @Override
    public double tax() {
        return getPrice() * (getVatTax() + getRegistrationTax());
    }

    @Override
    public double revenue() {
        return getPrice() + tax();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00 VND");
        String type =  "Xe may";
        String record = String.format("%-30s %-30s %15s %15d %-25s %25s %25s %-20s"
                , getBrand()
                , getManufacturer()
                , getSerialNumber()
                , getManufactureYear()
                , getOwner()
                , decimalFormat.format(getPrice())
                , decimalFormat.format(revenue())
                , type
        );
        return record;
    }
}
