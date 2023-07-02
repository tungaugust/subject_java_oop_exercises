package main.module_three;

import java.time.Year;

public abstract class Vehicle {
    private String brand;   // thuong hieu
    private String manufacturer; // nha san xuat
    private String serialNumber;
    private int manufactureYear; // nam san xuat
    private String owner; // chu so huu
    private double price; // gia chua thue

    private final double vatTax = 0.1; // Thue VAT = 10%
    private double registrationTax = 0.0; // Thue truoc ba
    private double exciseTax = 0.0; // Thue tieu thu dac biet

    public double getVatTax() {
        return vatTax;
    }

    public double getRegistrationTax() {
        return registrationTax;
    }

    public void setRegistrationTax(double registrationTax) {
        this.registrationTax = registrationTax;
    }

    public double getExciseTax() {
        return exciseTax;
    }

    public void setExciseTax(double exciseTax) {
        this.exciseTax = exciseTax;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicle(String brand, String manufacturer, String serialNumber, int manufactureYear, String owner, double price) {
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.manufactureYear = manufactureYear;
        this.owner = owner;
        this.price = price;
    }

    public static String headerLine(){
        return String.format("%-30s %-30s %15s %15s %-25s %25s %25s %-20s %-20s"
                , "THUONG HIEU", "NHA SAN XUAT", "SO SERI", "NAM SAN XUAT", "CHU XE", "DON GIA", "THANH TIEN", "LOAI XE", "GHI CHU"
        );
    }

    public abstract double tax();

    public abstract double revenue();

}
