package main.module_three;

import java.time.LocalDate;

public class SachThamKhao extends Sach {
    private double tax;

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public SachThamKhao(String code, LocalDate importDate, double price, int quantity, String publisher, double tax) {
        super(code, importDate, price, quantity, publisher);
        this.tax = tax;
    }

    @Override
    public double thanhTien() {
        return getQuantity() * getPrice() + getTax();
    }
}
