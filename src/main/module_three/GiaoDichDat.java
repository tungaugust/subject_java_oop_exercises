package main.module_three;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDichNhaDat {
    public static final String A_TYPE = "A";
    public static final String B_TYPE = "B";
    public static final String C_TYPE = "C";

    public GiaoDichDat(String code, LocalDate date, double price, String type, double area) {
        super(code, date, price, type, area);
    }

    @Override
    public double thanhTien() {
        if (getType().equals(B_TYPE) || getType().equals(C_TYPE)){
            return getPrice() * getArea();
        }
        if (getType().equals(A_TYPE)){
            return getPrice() * getArea() * 1.5;
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
                '}';
    }
}
