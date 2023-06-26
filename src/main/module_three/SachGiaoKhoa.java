package main.module_three;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
    private String status;
    public static final String OLD = "old";
    public static final String NEW = "new";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SachGiaoKhoa(String code, LocalDate importDate, double price, int quantity, String publisher, String status) {
        super(code, importDate, price, quantity, publisher);
        this.status = status;
    }

    @Override
    public double thanhTien() {
        if (getStatus().equals(NEW)){
            return getQuantity() * getPrice();
        } {
            return getQuantity() * getPrice() * 50 / 100;
        }
    }
}
