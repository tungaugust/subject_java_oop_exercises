package main.module_three;

import java.time.LocalDate;

public class KhachHangNuocNgoai extends KhachHang{
    private String nationality;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public KhachHangNuocNgoai(String code, String name, LocalDate date, int amount, double price, String nationality) {
        super(code, name, date, amount, price);
        this.nationality = nationality;
    }

    @Override
    public double thanhTien() {
        return getAmount() * getPrice();
    }

    public String toString() {
        return "KhachHang{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", date=" + getDate() +
                ", amount=" + getAmount() +
                String.format(", price=%.3f", getPrice()) +
                ", nationality='" + getNationality() + '\'' +
                '}';
    }
}
