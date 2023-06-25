package main.module_two;

public class Vehicle {
    private String owner;
    private String type;
    private double price;
    private int capacity;
    private double tax;

    public Vehicle(String owner, String type, double price, int capacity) {
        setOwner(owner);
        setType(type);
        setPrice(price);
        setCapacity(capacity);
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        if (owner.equals("")) {
            owner = "Unidentified Owner";
        }
        this.owner = owner;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        if (type.equals("")) {
            type = "Unidentified Type";
        }
        this.type = type;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0.0) {
            price = 0;
        }
        this.price = price;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        this.capacity = capacity;
    }

    private double getTax() {
        /* Tinh thue truoc ba cho xe */
        int percent = 1;
        if (this.capacity >= 100 && this.capacity <= 200) {
            percent = 3;
        } else if (this.capacity > 200) {
            percent = 5;
        }
        this.tax = this.price * percent / 100.0;
        return this.tax;
    }

    public static String headerLine(){
        return String.format("%-30s %-20s %15s %20s %20s"
                , "TEN CHU XE", "LOAI XE", "DUNG TICH", "TRI GIA", "THUE PHAI NOP"
        );
    }

    public String record() {
        String record = String.format("%-30s %-20s %15d %20.2f %20.2f"
                , getOwner()
                , getType()
                , getCapacity()
                , getPrice()
                , getTax()
        );
        return record;
    }
}
