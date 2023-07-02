package main.module_three;

import java.text.DecimalFormat;

public class Bike extends Vehicle{
    public Bike(String brand, String manufacturer, String serialNumber, int manufactureYear, String owner, double price) {
        super(brand, manufacturer, serialNumber, manufactureYear, owner, price);
    }

    @Override
    public double tax() {
        return 0;
    }

    @Override
    public double revenue() {
        return getPrice() + tax();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00 VND");
        String type =  "Xe dap";
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
