package main.module_three;

import java.time.LocalDate;

public class KhachHangVietNam extends KhachHang{
    private String type;
    private int threshold; // dinh muc
    public static final String LIVING_TYPE = "sinh hoat";
    public static final String BUSINESS_TYPE = "kinh doanh";
    public static final String MANUFACTURE_TYPE = "san xuat";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public KhachHangVietNam(String code, String name, LocalDate date, int amount, double price, String type, int threshold) {
        super(code, name, date, amount, price);
        this.type = type;
        this.threshold = threshold;
    }

    @Override
    public double thanhTien() {
        if (getAmount() <= getThreshold()){
            return getAmount() * getPrice();
        } else {
            int over = getAmount() - getThreshold();
            return getPrice() * (getThreshold() + over * 2.5);
        }
    }

    public String toString() {
        return "KhachHang{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", date=" + getDate() +
                ", amount=" + getAmount() +
                String.format(", price=%.3f", getPrice()) +
                ", type='" + getType() + '\'' +
                ", threshold=" + getThreshold() +
                '}';
    }
}
