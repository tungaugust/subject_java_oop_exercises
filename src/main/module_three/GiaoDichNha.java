package main.module_three;

import java.time.LocalDate;

public class GiaoDichNha extends GiaoDichNhaDat {
    private String address;
    public static final String REGULAR_TYPE = "thuong";
    public static final String LUXURY_TYPE = "cao cap";

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GiaoDichNha(String code, LocalDate date, double price, String type, double area, String address) {
        super(code, date, price, type, area);
        this.address = address;
    }

    @Override
    public double thanhTien() {
        if (getType().equals(REGULAR_TYPE)){
            return getPrice() * getArea() * 90 / 100;
        }
        if (getType().equals(LUXURY_TYPE)){
            return getPrice() * getArea();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "GiaoDichNhaDat{" +
                "code='" + getCode() + '\'' +
                ", date=" + getDate() +
                String.format(", price=%.3f", getPrice()) +
                ", type='" + getType() + '\'' +
                ", area=" + getArea() +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
